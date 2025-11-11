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

        st = new StringTokenizer(br.readLine());
        int[] prefix_sum = new int[N+1];

        for(int i=1; i<=N; i++){
            prefix_sum[i] = prefix_sum[i-1] + Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for(int i=K; i<prefix_sum.length; i++){
            int sum = prefix_sum[i] - prefix_sum[i-K];
            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}