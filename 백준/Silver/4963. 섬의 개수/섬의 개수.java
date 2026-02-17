import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
        	w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];
            cnt = 0;

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
        
        	sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int i, int j){
        visited[i][j] = true;

        for(int k=0; k<8; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;

            if(!visited[nx][ny] && map[nx][ny] == 1){
                dfs(nx, ny);
            }
        }
    }
}