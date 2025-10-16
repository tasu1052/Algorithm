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
            st = new StringTokenizer(br.readLine());
            
            int[] arr = new int[10];

            for(int i=0; i<arr.length; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for(int i=0; i<arr.length; i++){
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }

            int sum = 0;

            for(int i=0; i<arr.length; i++){
                if(arr[i] == max || arr[i] == min) continue;
                sum += arr[i];
            }

            double avg = sum / 8.0;

            sb.append("#").append(t).append(" ").append(Math.round(avg)).append('\n');
        }
        System.out.print(sb);
    }
}