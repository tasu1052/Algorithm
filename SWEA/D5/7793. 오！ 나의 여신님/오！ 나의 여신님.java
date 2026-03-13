import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;                  // 맵의 세로, 가로 크기
    static char[][] map;              // 입력 맵
    static int[][] deTime;            // 악마가 각 칸에 도달하는 최단 시간
    static int[][] suTime;            // 수연이가 각 칸에 도달하는 최단 시간
    static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            deTime = new int[N][M];
            suTime = new int[N][M];

            // 아직 방문하지 않았음을 -1로 표시
            for (int i = 0; i < N; i++) {
                Arrays.fill(deTime[i], -1);
                Arrays.fill(suTime[i], -1);
            }

            int sx = -1, sy = -1; // 수연 시작 위치
            int ex = -1, ey = -1; // 여신 위치
            ArrayDeque<int[]> devilQ = new ArrayDeque<>(); // 악마 BFS용 큐

            // 맵 입력 및 시작 위치들 저장
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j);

                    if (map[i][j] == 'S') {
                        sx = i;
                        sy = j;
                    } else if (map[i][j] == '*') {
                        // 악마는 여러 마리일 수 있으므로 전부 큐에 넣고 시작
                        devilQ.offer(new int[]{i, j});
                        deTime[i][j] = 0;
                    } else if (map[i][j] == 'D') {
                        ex = i;
                        ey = j;
                    }
                }
            }

            // 1. 먼저 악마가 각 칸에 언제 도착하는지 계산
            spreadDevil(devilQ);

            // 2. 그 정보를 바탕으로 수연이의 최단 탈출 시간 계산
            moveSuyeon(sx, sy);

            // 여신 위치에 도달 못했으면 GAME OVER
            sb.append('#').append(tc).append(' ');
            sb.append(suTime[ex][ey] == -1 ? "GAME OVER" : suTime[ex][ey]).append('\n');
        }

        System.out.print(sb);
    }

    // 악마가 퍼지는 시간을 BFS로 계산
    static void spreadDevil(ArrayDeque<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 맵 밖이면 패스
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 이미 악마 도착 시간이 기록된 칸이면 패스
                if (deTime[nx][ny] != -1) continue;

                // 악마는 빈칸(.)과 수연 시작 위치(S)로만 이동 가능
                // 돌(X)과 여신(D) 쪽으로는 이동 불가
                if (map[nx][ny] != '.' && map[nx][ny] != 'S') continue;

                // 다음 칸의 악마 도착 시간 기록
                deTime[nx][ny] = deTime[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    // 수연이가 여신에게 도달할 수 있는 최단 시간을 BFS로 계산
    static void moveSuyeon(int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        suTime[sx][sy] = 0; // 시작 위치 시간 0

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                int nextTime = suTime[x][y] + 1; // 다음 칸으로 이동했을 때 시간

                // 맵 밖이면 패스
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 이미 수연이가 방문한 칸이면 패스
                if (suTime[nx][ny] != -1) continue;

                // 여신 위치라면 바로 도착 처리
                // BFS이므로 처음 도달한 시간이 최단 시간
                if (map[nx][ny] == 'D') {
                    suTime[nx][ny] = nextTime;
                    return;
                }

                // 빈칸이 아니면 이동 불가
                if (map[nx][ny] != '.') continue;

                // 악마가 더 빨리 오거나, 같은 시간에 오는 칸이면 이동 불가
                if (deTime[nx][ny] != -1 && deTime[nx][ny] <= nextTime) continue;

                // 이동 가능한 칸이면 시간 기록 후 큐에 삽입
                suTime[nx][ny] = nextTime;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}