import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long D[][][] = new long[101][101][101];
        D[1][1][1] = 1;

        for(int i=2; i<=N; i++){
            for(int j=1; j<=L; j++){
                for(int k=1;k<=R; k++){
                    D[i][j][k] = (D[i-1][j][k] * (i-2) + 
                                  (D[i-1][j][k-1] + D[i-1][j-1][k])) 
                        % 1_000_000_007;
                }
            }
        }
        System.out.print(D[N][L][R]);
    }
}