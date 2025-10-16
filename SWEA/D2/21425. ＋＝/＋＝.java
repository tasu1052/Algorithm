import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long N = Long.parseLong(st.nextToken());

            long x = Math.min(A, B);
            long y = Math.max(A, B);
            long count = 0;

            while (y <= N) {
                long temp = x + y;
                x = y;
                y = temp;
                count++;
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
