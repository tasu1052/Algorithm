import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = new char[5][5];
    static boolean[] picked = new boolean[25]; // 0~24 선택 여부
    static int ans = 0;

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < 5; r++) {
            String line = br.readLine();
            for (int c = 0; c < 5; c++) {
                map[r][c] = line.charAt(c);
            }
        }

        comb(0, 0, 0, 0); // startIdx, cntPicked, cntS, cntY
        System.out.println(ans);
    }

    // 25칸 중 7칸을 조합으로 뽑는다
    static void comb(int start, int cnt, int cntS, int cntY) {
        // 가지치기: Y가 4명이면 S가 4 이상 불가능
        if (cntY >= 4) return;

        // 7명 다 뽑았으면 연결성 검사
        if (cnt == 7) {
            if (cntS >= 4 && isConnected()) ans++;
            return;
        }

        // 남은 칸으로 7명을 못 채우면 종료
        if (25 - start < 7 - cnt) return;

        for (int i = start; i < 25; i++) {
            picked[i] = true;

            int r = i / 5, c = i % 5;
            if (map[r][c] == 'S') comb(i + 1, cnt + 1, cntS + 1, cntY);
            else comb(i + 1, cnt + 1, cntS, cntY + 1);

            picked[i] = false;
        }
    }

    // picked된 7칸이 상하좌우로 모두 연결되어 있는지 BFS로 확인
    static boolean isConnected() {
        boolean[] vis = new boolean[25];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        // 시작점: picked된 첫 칸
        int start = -1;
        for (int i = 0; i < 25; i++) {
            if (picked[i]) { start = i; break; }
        }
        q.add(start);
        vis[start] = true;

        int connectedCount = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int r = cur / 5, c = cur % 5;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;

                int nxt = nr * 5 + nc;

                // 선택된 칸(picked)만 탐색
                if (picked[nxt] && !vis[nxt]) {
                    vis[nxt] = true;
                    q.add(nxt);
                    connectedCount++;
                }
            }
        }

        // BFS로 도달한 선택칸 수가 7이면 모두 연결
        return connectedCount == 7;
    }
}