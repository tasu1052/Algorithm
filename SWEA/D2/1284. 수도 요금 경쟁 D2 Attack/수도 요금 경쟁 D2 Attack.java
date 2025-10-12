import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int i=1; i<=T; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int Asum = P * W;

            int Bsum = 0;

            if(W<=R) Bsum = Q;
            else Bsum = Q + (W-R) * S;

            if(Asum>Bsum) sb.append("#").append(i).append(" ").append(Bsum).append('\n');
            else sb.append("#").append(i).append(" ").append(Asum).append('\n');
        }
        System.out.print(sb);
    }
}
