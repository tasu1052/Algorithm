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

            arr[0][0] = 1;
            
            for(int i=1; i<N; i++){
                for(int j=0; j<=i; j++){
                    if(j==0 || j==i) arr[i][j] = 1;
                    else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }

            sb.append("#").append(t).append('\n');
            for(int i=0; i<N; i++){
                for(int j=0; j<=i; j++){
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}