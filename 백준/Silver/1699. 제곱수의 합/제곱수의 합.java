import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] D = new int[N+1];

        D[0] = 0;

        for(int i=1; i<=N; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){
                min = Math.min(min, D[i-j*j]+1);
            }
            D[i] = min;
        }
        System.out.print(D[N]);
    }
}