import java.io.*;
import java.util.*;
   
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int t=1; t<=T; t++){
            br.readLine(); // 테스트케이스 번호 무시
            int[][] arr = new int[100][100];

            for(int i=0; i<100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = Integer.MIN_VALUE;
            int diaSum1 = 0, diaSum2 = 0;

            for(int i=0; i<100; i++){
                int rowSum = 0, colSum = 0;
                for(int j=0; j<100; j++){
                    rowSum += arr[i][j];
                    colSum += arr[j][i];
                }
                diaSum1 += arr[i][i];
                diaSum2 += arr[i][99-i];
                max = Math.max(max, Math.max(rowSum, colSum));
            }

            max = Math.max(max, Math.max(diaSum1, diaSum2));
            sb.append("#").append(t).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
    }
}
