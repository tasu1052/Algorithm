import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cnt;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visited = new boolean[N][M];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(arr[i][j] == 1)
                        bfs(i, j);
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
    static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        arr[i][j] = 0;
        q.add(new int[]{i, j});
        cnt++;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if(x >= 0 && y >= 0 && x < N && y < M){
                    if(arr[x][y] == 1 && !visited[x][y]){
                        visited[x][y] = true;
                        arr[x][y] = 0;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}