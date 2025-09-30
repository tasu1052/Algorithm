import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            double sum = 0;
            for(int j=0; j<10; j++){
                sum += Double.parseDouble(st.nextToken());
            }
            double avg = Math.round(sum/10);
            sb.append("#").append(i+1).append(" ").append((int)avg)
                .append('\n');
        }
        System.out.print(sb);
    }
}