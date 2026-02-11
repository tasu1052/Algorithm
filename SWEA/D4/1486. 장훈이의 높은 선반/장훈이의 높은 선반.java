import java.io.*;
import java.util.*;

public class Solution {
	static int N, B;
	static int minH;
	static int[] height;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            height = new int[N];
            minH = Integer.MAX_VALUE;
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) height[i] = Integer.parseInt(st.nextToken());
            
            dfs(0, 0);
            
            

            sb.append('#').append(tc).append(' ').append(minH - B).append('\n');
        }
        System.out.println(sb);
    }
    
    static void dfs(int idx, int sum) {
    	if(sum >= B) {
    		minH = Math.min(minH, sum);
    		return;
    	}
    	
    	if(idx == N) {
    		return;
    	}
    	
    	dfs(idx + 1, sum + height[idx]);
    	
    	dfs(idx + 1, sum);
    }
}
