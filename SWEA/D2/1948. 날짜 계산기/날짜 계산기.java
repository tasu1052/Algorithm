import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
            for (int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            int monthdiff = em - sm;
            int daydiff = ed - sd + 1;

            int sum = daydiff;

            for(int i=sm-1; i<sm+monthdiff-1; i++){
                sum +=arr[i];
            }

            
            sb.append("#").append(t).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
    }
}