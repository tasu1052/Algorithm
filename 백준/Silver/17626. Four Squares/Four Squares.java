import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //dp[i] = k -> 어떤 수 i에 대해 가질 수 있는 제곱수 최소 개수 k
        int[] dp = new int[N+1];

        for(int i=1; i*i<=N; i++){
            dp[i * i] = 1;
        }

        for(int i=1; i<=N; i++) dp[i] = i;

        for(int i=2; i<=N; i++){
            for(int j=1; j * j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i - (j*j)] + 1);
            }
        }

        System.out.print(dp[N]);
    }
}