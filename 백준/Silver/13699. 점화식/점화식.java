import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long[] D = new long[91];

        D[0] = 1;

        for(int i=1; i<=N; i++){
            for(int j=i-1, k=0; j>=0; j--, k++){
                D[i] += D[k] * D[j];
            }
        }
        System.out.print(D[N]);
    }
}