import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);

        while(n > 0 && m > 0){
            if(s1.charAt(n-1) == s2.charAt(m-1)){
                sb.append(s1.charAt(n-1));
                n--;
                m--;
            }
            else if(dp[n-1][m] >= dp[n][m-1]){
                n--;
            }
            else{
                m--;
            }
        }
        sb.reverse();
        
        System.out.print(sb);
    }
}