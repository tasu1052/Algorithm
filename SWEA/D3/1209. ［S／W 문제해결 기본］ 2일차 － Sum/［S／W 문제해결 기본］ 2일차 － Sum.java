import java.io.*;
import java.util.*;
   
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
           
        for(int t=1; t<=T; t++){
            int tc = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];

            for(int i=0; i<100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = Integer.MIN_VALUE;

            for(int i=0; i<100; i++){
                int sum = 0;
                for(int j=0; j<100; j++){
                    sum += arr[i][j];
                }
                max = Math.max(max, sum);
            }

            for(int i=0; i<100; i++){
                int sum = 0;
                for(int j=0; j<100; j++){
                    sum += arr[j][i];
                }
                max = Math.max(max, sum);
            }

            int diaSum = 0;
            for(int i=0; i<100; i++){
                diaSum += arr[i][i];
            }

            max = Math.max(max, diaSum);
              
            sb.append("#").append(t).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
    }
}