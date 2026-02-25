import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int ans;

    // dir: 0->1->2->3 순서로만 진행 (직진 or 우회전 1번)
    static final int[] dx = { 1, -1, -1,  1};
    static final int[] dy = { 1,  1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            ans = -1;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    HashSet<Integer> eat = new HashSet<>();
                    eat.add(map[i][j]);
                    visited[i][j] = true;

                    dfs(0, i, j, i, j, eat, 0, 0);

                    visited[i][j] = false;
                }
            }

            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int len, int sx, int sy, int x, int y, HashSet<Integer> eat, int dir, int turn) {
        // 시작점에 "도착"한 상태는 moveTo에서만 만들도록 해도 되고,
        // 지금처럼 방어적으로 둬도 됨.
        if (len != 0 && x == sx && y == sy) {
            if (turn == 3) ans = Math.max(ans, len);
            return;
        }

        // 1) 직진
        moveTo(len, sx, sy, x, y, eat, dir, turn);

        // 2) 우회전(최대 3번만)
        if (turn < 3 && dir + 1 < 4) {
            moveTo(len, sx, sy, x, y, eat, dir + 1, turn + 1);
        }
    }

    static void moveTo(int len, int sx, int sy, int x, int y, HashSet<Integer> eat,
                       int ndir, int nturn) {

        int nx = x + dx[ndir];
        int ny = y + dy[ndir];

        // 범위 밖이면 불가
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) return;

        // 시작점으로 돌아오는 경우: 마지막 턴(3번 꺾기)일 때만 인정
        if (nx == sx && ny == sy) {
            if (nturn == 3) dfs(len + 1, sx, sy, nx, ny, eat, ndir, nturn);
            return;
        }

        // 일반 이동: 방문/중복 디저트 체크
        int dessert = map[nx][ny];
        if (visited[nx][ny] || eat.contains(dessert)) return;

        visited[nx][ny] = true;
        eat.add(dessert);

        dfs(len + 1, sx, sy, nx, ny, eat, ndir, nturn);

        eat.remove(dessert);
        visited[nx][ny] = false;
    }
}