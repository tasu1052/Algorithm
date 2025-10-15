import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] money = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10};
        
        for (int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] count = new int[8];

            int idx = 0;
            
            for (int i = 0; i < 8; i++) {
                count[i] = N / money[i];
                N %= money[i];
            }


            sb.append("#").append(t).append('\n');
            
            for(int i=0; i<8; i++){
                sb.append(count[i]).append(" ");
            }

            sb.append('\n');
        }
        System.out.print(sb);
    }
}