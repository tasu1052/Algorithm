import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());

            long[] P = new long[N];
            P[0] = 1;
            if(N>1) P[1] = 1;
            if(N>2) P[2] = 1;
            for(int j=3; j<N; j++){
                P[j] = P[j-3] + P[j-2];
            }
            sb.append(P[N-1]).append('\n');
        }
        System.out.print(sb);
    } 
}
