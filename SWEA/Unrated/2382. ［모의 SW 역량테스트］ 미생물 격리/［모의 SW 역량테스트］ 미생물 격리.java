import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static ArrayDeque<Micro> q;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 셀 크기
            M = Integer.parseInt(st.nextToken()); // 격리 시간
            K = Integer.parseInt(st.nextToken()); // 군집 수

            q = new ArrayDeque<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                dir--;

                q.add(new Micro(r, c, num, dir));
            }

            simulate();

            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.print(sb);
    }

    static void simulate() {
        for (int t = 0; t < M; t++) {
            int[][] sum = new int[N][N];      // 그 칸에 모인 총 미생물 수
            int[][] max = new int[N][N];      // 그 칸에 모인 군집 중 최대 미생물 수
            int[][] dirKeep = new int[N][N];  // 최대 군집의 방향

            int size = q.size();
            for (int s = 0; s < size; s++) {
                Micro cur = q.poll();

                int nx = cur.r + dx[cur.dir];
                int ny = cur.c + dy[cur.dir];

                int num = cur.num;
                int dir = cur.dir;

                if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
                    num /= 2;
                    dir = dir ^ 1;
                    if (num == 0) continue;
                }

                sum[nx][ny] += num;

                if (num > max[nx][ny]) {
                    max[nx][ny] = num;
                    dirKeep[nx][ny] = dir;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (sum[i][j] > 0) {
                        q.add(new Micro(i, j, sum[i][j], dirKeep[i][j]));
                    }
                }
            }
        }

        ans = 0;
        for (Micro m : q) ans += m.num;
    }

    static class Micro {
        int r, c, num, dir;
        Micro(int r, int c, int num, int dir) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.dir = dir;
        }
    }
}