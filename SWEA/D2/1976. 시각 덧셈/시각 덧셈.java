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

            int fh = Integer.parseInt(st.nextToken());
            int fm = Integer.parseInt(st.nextToken());
            int sh = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());

            int hsum = fh + sh;
            int msum = fm + sm;

            if(msum >= 60){
                hsum += 1;
                msum -= 60;
            }

            if(hsum > 12) hsum -= 12;

            sb.append("#").append(t).append(" ").append(hsum)
                .append(" ").append(msum).append('\n');
        }
        System.out.print(sb);
    }
}