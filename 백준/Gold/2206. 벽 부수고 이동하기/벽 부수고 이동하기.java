import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][][] visited;
    static int[][][] dist;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        dist = new int[N][M][2];

        for (int i=0; i<N; i++) {
            for(int j=0; j<M; j++)
                Arrays.fill(dist[i][j], -1);
        }
        
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        int a = dist[N-1][M-1][0];
        int b = dist[N-1][M-1][1];

        if (a == -1 && b == -1) System.out.println(-1);
        else if (a == -1) System.out.println(b);
        else if (b == -1) System.out.println(a);
        else System.out.println(Math.min(a, b));
    }
    static void bfs(int i, int j){
        Queue<int[]> q =new LinkedList<>();
        q.add(new int[]{i, j, 0});
        visited[i][j][0] = true;
        dist[0][0][0] = 1;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                int broken = now[2];
                if(x>=0 && y>=0 && x<N && y<M){
                    if(map[x][y] == 0 && !visited[x][y][broken]){
                        visited[x][y][broken] = true;
                        dist[x][y][broken] = dist[now[0]][now[1]][broken] + 1;
                        q.add(new int[]{x, y, broken});
                    }
                    if(map[x][y] == 1 && broken == 0 && !visited[x][y][1]){
                        visited[x][y][1] = true;
                        dist[x][y][1] = dist[now[0]][now[1]][0] + 1;
                        q.add(new int[]{x, y, 1});
                    }
                }
            }
        }
    }
}