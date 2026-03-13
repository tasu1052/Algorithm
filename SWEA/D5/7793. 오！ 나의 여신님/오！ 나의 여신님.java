import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static char[][] map;
    static int[][] deTime;
    static int[][] suTime;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            deTime = new int[N][M];
            suTime = new int[N][M];

            for (int i = 0; i < N; i++) {
                Arrays.fill(deTime[i], -1);
                Arrays.fill(suTime[i], -1);
            }

            int sx = -1, sy = -1;
            int ex = -1, ey = -1;
            ArrayDeque<int[]> devilQ = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j);

                    if (map[i][j] == 'S') {
                        sx = i;
                        sy = j;
                    } else if (map[i][j] == '*') {
                        devilQ.offer(new int[]{i, j});
                        deTime[i][j] = 0;
                    } else if (map[i][j] == 'D') {
                        ex = i;
                        ey = j;
                    }
                }
            }

            spreadDevil(devilQ);
            moveSuyeon(sx, sy);

            sb.append('#').append(tc).append(' ');
            sb.append(suTime[ex][ey] == -1 ? "GAME OVER" : suTime[ex][ey]).append('\n');
        }

        System.out.print(sb);
    }

    static void spreadDevil(ArrayDeque<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (deTime[nx][ny] != -1) continue;
                if (map[nx][ny] != '.' && map[nx][ny] != 'S') continue;

                deTime[nx][ny] = deTime[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    static void moveSuyeon(int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        suTime[sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                int nextTime = suTime[x][y] + 1;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (suTime[nx][ny] != -1) continue;

                if (map[nx][ny] == 'D') {
                    suTime[nx][ny] = nextTime;
                    return;
                }

                if (map[nx][ny] != '.') continue;
                if (deTime[nx][ny] != -1 && deTime[nx][ny] <= nextTime) continue;

                suTime[nx][ny] = nextTime;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}