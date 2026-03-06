import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] input;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[] parent;
    static ArrayList<Node> arr = new ArrayList<>();
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N][M];
        map = new int[N][M];
        vis = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 섬 번호 붙이기
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (input[i][j] == 1 && !vis[i][j]) {
                    bfs(i, j, num);
                    num++;
                }
            }
        }

        int islandCnt = num - 1;

        // 섬이 0개 or 1개면 다리 필요 없음
        if (islandCnt <= 1) {
            System.out.println(0);
            return;
        }

        // 2. 최소 간선 길이 저장
        dist = new int[islandCnt + 1][islandCnt + 1];
        for (int i = 1; i <= islandCnt; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        buildBridge(i, j, dir);
                    }
                }
            }
        }

        // dist 배열 -> 간선 리스트
        for (int i = 1; i <= islandCnt; i++) {
            for (int j = i + 1; j <= islandCnt; j++) {
                if (dist[i][j] != Integer.MAX_VALUE) {
                    arr.add(new Node(i, j, dist[i][j]));
                }
            }
        }

        // 3. 크루스칼
        parent = new int[islandCnt + 1];
        for (int i = 1; i <= islandCnt; i++) parent[i] = i;

        Collections.sort(arr);

        int edgeCnt = 0;
        int ans = 0;

        for (Node e : arr) {
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);
                ans += e.distance;
                edgeCnt++;

                if (edgeCnt == islandCnt - 1) break;
            }
        }

        if (edgeCnt == islandCnt - 1) System.out.println(ans);
        else System.out.println(-1);
    }

    static void buildBridge(int x, int y, int dir) {
        int start = map[x][y];
        int len = 0;

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (true) {
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;

            // 자기 섬이면 불가
            if (map[nx][ny] == start) return;

            // 바다면 계속 전진
            if (map[nx][ny] == 0) {
                len++;
                nx += dx[dir];
                ny += dy[dir];
                continue;
            }

            // 다른 섬 도착
            if (len >= 2) {
                int end = map[nx][ny];
                dist[start][end] = Math.min(dist[start][end], len);
                dist[end][start] = Math.min(dist[end][start], len);
            }
            return;
        }
    }

    static void bfs(int i, int j, int num) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        vis[i][j] = true;
        map[i][j] = num;
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (!vis[nx][ny] && input[nx][ny] == 1) {
                    vis[nx][ny] = true;
                    map[nx][ny] = num;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}

class Node implements Comparable<Node> {
    int from, to, distance;

    Node(int from, int to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.distance, o.distance);
    }
}