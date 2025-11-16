import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] sumArr = new int[N+1][N+1];

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                sumArr[i][j] = sumArr[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int t=0; t<M; t++){
            st = new StringTokenizer(br.readLine());
        
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            long sum = 0;
            for(int i=x1; i<=x2; i++){
                sum += sumArr[i][y2] - sumArr[i][y1-1];
            }
        sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
