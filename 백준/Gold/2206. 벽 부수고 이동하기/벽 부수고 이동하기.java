import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] dist;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][2];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                Arrays.fill(dist[i][j], -1);
            }
        }

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<2; i++){
            if(dist[N-1][M-1][i] != -1) ans = Math.min(ans, dist[N-1][M-1][i]);
        }

        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
    }
    static void bfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});
        dist[0][0][0] = 1;

        while(!q.isEmpty()){
            int[] now  = q.poll();
            int x =  now[0], y = now[1], broken = now[2];

            for(int k=0; k<4; k++){
                int nx = x + dx[k], ny =  y + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(map[nx][ny] == 0 && dist[nx][ny][broken] == -1){
                    dist[nx][ny][broken] = dist[x][y][broken] + 1;
                    q.add(new int[]{nx, ny, broken});
                }

                if(map[nx][ny] == 1 && broken == 0 && dist[nx][ny][broken] == -1){
                    dist[nx][ny][broken+1] = dist[x][y][broken] + 1;
                    q.add(new int[]{nx, ny, broken + 1});
                }
            }
        }
    }
}