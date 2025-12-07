import java.io.*;
import java.util.*;

public class Main{
    static int[][] map;
    static int[] dx = {2, 2, -2, -2, 1, -1, -1, 1};
    static int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};
    static boolean[][] visited;
    static int l;
    static int ex, ey;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            bfs(sx, sy);
        }
        System.out.print(sb);
    }
    static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i, j});

        while(!q.isEmpty()){
            int[] now = q.poll();

            if(now[0] == ex && now[1] == ey){
                sb.append(map[now[0]][now[1]]).append('\n');
                return;
            }
            for(int k=0; k<8; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if(x<0 || y<0 || x>=l || y>=l) continue;

                if(!visited[x][y]){
                    visited[x][y] = true;
                    map[x][y] = map[now[0]][now[1]] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }
    }
}