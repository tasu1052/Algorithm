import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        int sx = 0;
        int sy = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    sx = i;
                    sy = j;
                }
            }
        }
        bfs(sx, sy);

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
    }
    static void bfs(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        arr[sx][sy] = 0;
        visited[sx][sy] = true;
        q.add(new int[]{sx, sy});

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if(x >= 0 && y >= 0 && x < N && y < M){
                    if(arr[x][y] == 1 && !visited[x][y]){
                        visited[x][y] = true;
                        arr[x][y] = arr[now[0]][now[1]] + 1;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 1 && !visited[i][j]) arr[i][j] = -1;
            }
        }
    }
}