import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            
            for(int i=0; i<N; i++){
                String S = br.readLine();
                for(int j=0; j<N; j++){
                    arr[i][j] = S.charAt(j) - '0';
                }
            }

            int sum = 0;
            for(int i=0; i<N; i++){
                int range = Math.abs(N/2-i);
                for(int j=range; j<N-range; j++){
                    sum += arr[i][j];
                }
            }
            
            sb.append("#").append(t).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
    }
}