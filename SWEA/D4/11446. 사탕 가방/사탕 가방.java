import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long M = Long.parseLong(st.nextToken());
            
            long[] candy = new long[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) candy[i] = Long.parseLong(st.nextToken());
            
            long start = 1;
            long end = Long.MAX_VALUE-1;
            
            while(start <= end) {
            	long sum = 0;
            	long mid = (start + end) / 2;
            	
            	for(int i=0; i<N; i++) {
            		sum += candy[i] / mid;
            		if(sum >= M) break;
            	}
            	
            	if(sum >= M) start = mid + 1;
            	else end = mid - 1;
            }
            
            sb.append('#').append(tc).append(' ').append(end).append('\n');
        }
        System.out.println(sb);
    }
}
