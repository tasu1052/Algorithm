import java.io.*;
import java.util.*;

public class Main{
    static int[][] A;
    static boolean[][] visited;
    static int N;
    static int[] houseNum;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N][N];
        visited = new boolean[N][N];
        houseNum = new int[N * N];
        
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                A[i][j] = s.charAt(j) - '0';
            }
        }

        int num = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(A[i][j] == 1 && !visited[i][j]){
                    houseNum[num++] = bfs(i, j);
                }
            }
        }
        Arrays.sort(houseNum);

        sb.append(num).append('\n');
        for(int i=0; i<houseNum.length; i++){
            if(houseNum[i] != 0) sb.append(houseNum[i]).append('\n');
        }

        System.out.print(sb);
    }
    static int bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});
        visited[i][j] = true;
        
        int count = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            count++;

            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if(x >= 0 && y >= 0 && x < N && y < N){
                    if(A[x][y] == 1 && !visited[x][y]){
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        return count;
    }
}