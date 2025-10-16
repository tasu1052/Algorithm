import java.io.*;
import java.util.*;

public class Solution {
    static int[][] arr = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int t=1; t<=T; t++){
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[101];

            st = new StringTokenizer(br.readLine());
            
            for(int i=0; i<1000; i++){
                arr[Integer.parseInt(st.nextToken())]++;
            }
            
            int max = Integer.MIN_VALUE;
            for(int i=0; i<101; i++){
                max = Math.max(max, arr[i]);
            }

            int most = 0;
            for(int i=0; i<101; i++){
                if(arr[i]==max) most = i; 
            }
            sb.append("#").append(num).append(" ").append(most).append('\n');
        }
        System.out.print(sb);
    }
}