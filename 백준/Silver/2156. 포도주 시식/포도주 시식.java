import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cup = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            cup[i] = Integer.parseInt(br.readLine());
        }

        if(n>=1) dp[1] = cup[1];
        if(n>=2) dp[2] = cup[1] + cup[2];
        if(n>=3) {
            int temp = Math.max(cup[1] + cup[2], cup[1] + cup[3]);
            dp[3] = Math.max(temp, cup[2] + cup[3]);
        }

        for(int i=4; i<=n; i++){
            int tmp = Math.max(dp[i-1], dp[i-2]+cup[i]);
            dp[i] = Math.max(tmp, dp[i-3]+cup[i-1]+cup[i]);
        }
        System.out.print(dp[n]);
    } 
}