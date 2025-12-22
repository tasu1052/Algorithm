import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            
            long[] D = new long[N+1];

            D[1] = 1;
            if(N>=2) D[2] = 2;
            if(N>=3) D[3] = 4;

            for(int i=4; i<=N; i++){
                D[i] = ((long) (D[i-1] + D[i-2] + D[i-3])) % 1_000_000_009;
            }
            sb.append(D[N]).append('\n');
        }
        System.out.print(sb);
    }
}