import java.io.*;
import java.util.*;

public class Solution {
	static long N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Long.parseLong(br.readLine());
            
            long cnt = 0;
            
            while(N != 2) {
            	long num = (long)Math.sqrt(N);
                
            	if(num * num == N) {
            		N = num;
            		cnt++;
            	} else {
            		long next = (num + 1) * (num + 1);
            		cnt += next - N + 1;
            		N = num + 1;
            	}
            }
            
            sb.append('#').append(tc).append(' ').append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
