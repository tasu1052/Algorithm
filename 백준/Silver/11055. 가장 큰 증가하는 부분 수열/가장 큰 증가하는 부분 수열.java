import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            dp[i] = A[i];
            for(int j=0; j<i; j++){
                if(A[j] < A[i]){
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int num : dp){
            max = Math.max(max, num);
        }
        System.out.print(max);
    }
}