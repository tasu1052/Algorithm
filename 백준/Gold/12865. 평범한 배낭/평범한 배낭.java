import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weight = new int[N+1];
        int[] value = new int[N+1];
        int[][] dp = new int[N+1][K+1];
        
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            for(int w=0; w<=K; w++){
                if(w >= weight[i]){
                    dp[i][w] = Math.max(dp[i-1][w], 
                                        dp[i-1][w-weight[i]] + value[i]);
                }
                else dp[i][w] = dp[i-1][w];
            }
        }
        System.out.print(dp[N][K]);
    }
}