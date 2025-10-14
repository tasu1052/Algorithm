import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for (int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            sb.append("#").append(t).append('\n');

            int idx = N-1;
            for(int i=0; i<N; i++){
               for(int j=N-1; j>=0; j--){
                   sb.append(arr[j][i]);
               }
                sb.append(" ");

                for(int j=N-1; j>=0; j--){
                    sb.append(arr[N-1-i][j]);
                }
                sb.append(" ");

                for(int j=0; j<N; j++){
                   sb.append(arr[j][N-1-i]);
               }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}