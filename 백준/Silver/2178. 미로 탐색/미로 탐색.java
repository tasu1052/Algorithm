import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int[][] dist;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) Arrays.fill(dist[i], -1);

        bfs(0, 0);
        
        System.out.print(dist[N-1][M-1]);
    }

    static void bfs(int i, int j){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        dist[i][j] = 1;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int k=0; k<4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(dist[nx][ny] == -1 && map[nx][ny] == 1){
                    dist[nx][ny] = dist[now[0]][now[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}