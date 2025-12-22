import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] D = new int[N+1][10];

        for(int i=0; i<10; i++) D[1][i] = 1;

        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<=j; k++){
                    D[i][j] += D[i-1][k] % 10_007;
                }
            }
        }
        long sum = 0;
        for(int i=0; i<10; i++) sum += D[N][i];

        System.out.print(sum % 10_007);
    }
}