import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int maxH = 0;
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
            }
        }
        for(int h=0; h<=maxH; h++){
            visited = new boolean[N][N];
            int cnt = 0;
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] <= h) map[i][j] = 0;
                }
            }
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        
        System.out.print(max);
    }

    static void dfs(int i, int j){
        visited[i][j] = true;

        for(int k=0; k<4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            if(!visited[nx][ny] && map[nx][ny] != 0){
                dfs(nx, ny);
            }
        }
    }
}