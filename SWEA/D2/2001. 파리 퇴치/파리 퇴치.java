import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for (int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = Integer.MIN_VALUE;
            int sum = 0;
            
            for(int i=0; i<=N-M; i++){
                for(int j=0; j<=N-M; j++){
                    for(int k=i; k<i+M; k++){
                        for(int l=j; l<j+M; l++){
                            sum += arr[k][l];
                        }
                    }
                    max = Math.max(max, sum);
                    sum = 0;
                }
            }
            sb.append("#").append(t).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
    }
}