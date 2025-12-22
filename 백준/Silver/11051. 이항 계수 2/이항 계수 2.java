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

        int[][] D = new int[N+1][N+1];

        D[1][0] = 1;
        D[1][1] = 1;

        for(int i=2; i<=N; i++){
            for(int j=0; j<=i; j++){
                if(j == 0) D[i][j] = 1;
                else if(j==i) D[i][j] = 1;
                else D[i][j] = (D[i-1][j-1] + D[i-1][j]) % 10_007;
            }
        }
        System.out.print(D[N][K]);
    }
}