import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=T; i++){
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            for(int j=1; j<=N; j++){
                if(j%2==0) sum -= j;
                else sum += j;
            }

            sb.append("#").append(i).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
    }
}