import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            dist = new int[N][N];
            for(int i=0; i<N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[0][0] = 0;

            for(int i=0; i<N; i++){
                String line = br.readLine();
                for(int j=0; j<N; j++){
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            bfs(0, 0);

            sb.append("#").append(tc).append(" ").append(dist[N-1][N-1]).append('\n');
        }

        System.out.print(sb);
    }
    static void bfs(int i, int j){
        PriorityQueue<int[]> q = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[2]));
        q.add(new int[]{i, j, 0});

        while(!q.isEmpty()){
            int[] now = q.poll();

            if(now[2] != dist[now[0]][now[1]]) continue;
            if(now[0] == N-1 && now[1] == N-1) break;

            for(int k=0; k<4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                
                int ncost = now[2] + map[nx][ny];
                if(dist[nx][ny] > ncost){
                    dist[nx][ny] = ncost;
                    q.add(new int[]{nx, ny, ncost});
                }
            }
        }
    }
}