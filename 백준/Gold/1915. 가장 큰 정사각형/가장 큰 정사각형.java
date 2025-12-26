import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j) - '0';
                if(arr[i][j] == 1) dp[i][j] = 1;
            }
        }

        int max = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = Math.min(
                                    dp[i-1][j-1],
                                    Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.print(max * max);
    }
}