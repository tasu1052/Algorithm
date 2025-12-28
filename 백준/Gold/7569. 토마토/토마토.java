import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] map;
    static boolean[][][] visited;
    static int[][][] dist;
    static int N, M, H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];
        visited = new boolean[N][M][H];
        dist = new int[N][M][H];
        Queue<int[]> q = new LinkedList<>();

        boolean check = true;
        for(int h=0; h<H; h++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j][h] = Integer.parseInt(st.nextToken());
                    if(map[i][j][h] == 1){
                        q.add(new int[]{i, j, h});
                        visited[i][j][h] = true;
                    }
                    if(map[i][j][h] == 0) check = false;
                }
            }
        }
        if(check){
            System.out.print(0);
            return;
        }
        
        for(int h=0; h<H; h++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j][h] == -1) dist[i][j][h] = -1;
                    else dist[i][j][h] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int k=0; k<6; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                int z = now[2] + dz[k];

                if(x<0 || y<0 || z<0 || x>=N || y>=M || z>=H) continue;

                if(map[x][y][z] == 0 && !visited[x][y][z]){
                    visited[x][y][z] = true;
                    map[x][y][z] = 1;
                    dist[x][y][z] = dist[now[0]][now[1]][now[2]] + 1;
                    q.add(new int[]{x, y, z});
                }
            }
        }

        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int h=0; h<H; h++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j][h] == 0) count++;
                    max = Math.max(dist[i][j][h], max);
                }
            }
        }
        if(count >= 1){
            System.out.print(-1);
            return;
        }
        System.out.print(max);
    }
}