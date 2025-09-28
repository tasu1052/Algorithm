import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                if(st.hasMoreTokens())
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int max = Integer.MIN_VALUE;
        dp[0][0] = arr[0][0];
        
        for(int i=1; i<N; i++){
            for(int j=0; j<N; j++){
                if(j==0){
                    dp[i][j] = arr[i][j] + dp[i-1][0];
                }
                else if(j==i){
                    dp[i][j] = arr[i][j] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1],
                                                dp[i-1][j]);
                }
            }
        }
        for(int i=0; i<N; i++){
            max = Math.max(max, dp[N-1][i]);
            }
        
        System.out.print(max);
    } 
}
