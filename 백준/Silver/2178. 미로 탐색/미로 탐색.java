import java.io.*;
import java.util.*;

public class Main{
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        bfs(0, 0);
        System.out.print(A[N-1][M-1]);
    }
    static void bfs(int i, int j){
        Queue<int[]> q =new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && y>=0 && x<N && y<M){
                    if(A[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}