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
        int[] LIS = new int[N];
        int[] LDS = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            LIS[i] = 1;
            LDS[i] = 1;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(A[j] < A[i]){
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }
        for(int i=N-1; i>=0; i--){
            for(int j=N-1; j>i; j--){
                if(A[j] < A[i]){
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }
        int max= Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            dp[i] = LIS[i] + LDS[i] - 1;
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);
    }
}