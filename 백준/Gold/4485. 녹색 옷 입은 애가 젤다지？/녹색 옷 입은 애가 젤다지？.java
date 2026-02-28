import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int idx = 1;
        while(true){
            int N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            int[][] map = new int[N][N];
            int[][] dist = new int[N][N];
            for(int i=0; i<N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
            
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{0, 0});
            dist[0][0] = map[0][0];

            while(!q.isEmpty()){
                int[] now = q.poll();

                int x = now[0], y = now[1];

                for(int k=0; k<4; k++){
                    int nx = x + dx[k], ny = y + dy[k];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    if(dist[nx][ny] > dist[x][y] + map[nx][ny]){
                        dist[nx][ny] = dist[x][y] + map[nx][ny];
                        q.add(new int[]{nx, ny});
                    }
                }
            }

            sb.append("Problem ").append(idx++).append(": ")
                .append(dist[N-1][N-1]).append('\n');
        }

        System.out.print(sb);
    }
}