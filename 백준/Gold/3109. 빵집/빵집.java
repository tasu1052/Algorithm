import java.io.*;
import java.util.*;

class Main {
    static int[] dr = {-1, 0, 1};
    static int[] dc = {1, 1, 1};
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        
        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = s.charAt(j);
            }
        }

        cnt = 0;

        for(int i=0; i<R; i++) {
            if(dfs(i, 0)) cnt++;
        }

        System.out.print(cnt);
    }
    static boolean dfs(int r, int c){
        visited[r][c] = true;

        if(c == C-1) return true;
        for(int k=0; k<3; k++){
            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if(visited[nr][nc] || map[nr][nc] == 'x') continue;

            if(dfs(nr, nc)) return true;
        }
        return false;
    }
}