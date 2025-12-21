import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        long[] D = new long[N+2];

        for(int i=N; i>=1; i--){
            if(i + T[i] <= N + 1) D[i] = Math.max(D[i+1], P[i] + D[i+T[i]]);
            else D[i] = D[i+1];
        }
        
        System.out.print(D[1]);
    }
}