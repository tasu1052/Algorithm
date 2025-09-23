import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[1] = 1;

        if(N>1) dp[2] = 2;

        for(int i=3; i<N+1; i++){
            dp[i] = (dp[i-2] + dp[i-1])%15746;
        }
        System.out.print(dp[N]);
    } 
}
