import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] D = new int[46];

        D[0] = 0;
        D[1] = 1;

        for(int i=2; i<=N; i++){
            D[i] = D[i-1] + D[i-2];
        }
        System.out.print(D[N]);
    }
}