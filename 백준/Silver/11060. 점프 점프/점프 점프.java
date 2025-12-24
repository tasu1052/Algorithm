import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=0; i<N-1; i++){
            if(dp[i] == Integer.MAX_VALUE) continue;
            
            for(int j=i+1; j<=i+arr[i] && j<N; j++){
               dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        if(dp[N-1] == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(dp[N-1]);
    }
}