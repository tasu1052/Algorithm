import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<T; i++){
            int max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                if(st.hasMoreTokens()){
                    max = Math.max(max, Integer.parseInt(st.nextToken()));
                }
            }
            sb.append("#").append(i+1).append(" ")
                        .append(max).append('\n');
        }
        System.out.print(sb);
    }
}