import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for (int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            int x = 0, y = 0;
            int dir = 0;
            for(int num = 1; num<=N*N; num++){
                arr[x][y] = num;

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx<0 || nx>=N || ny<0 || ny>=N || arr[nx][ny] != 0){
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                x = nx;
                y = ny;
            }

            sb.append("#").append(t).append('\n');
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}