import java.io.*;
import java.util.*;

public class Solution {
    static int N, X, M;
    static int[] ans;
    static int[] tmp;
    static int[] hamNum;
    static int[] start, end, num;
    static int maxSum;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	for (int tc = 1; tc <= T; tc++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		X = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		
    		ans = new int[N];
    		tmp = new int[N+1];
    		hamNum = new int[X+1];
    		for(int i=0; i<=X; i++) hamNum[i] = i;
    		
    		start = new int[M];
			end = new int[M];
			num = new int[M];
			
			maxSum = -1;
    		
    		for(int i=0; i<M; i++) {
    			st = new StringTokenizer(br.readLine());
    			int l = Integer.parseInt(st.nextToken());
    			int r = Integer.parseInt(st.nextToken());
    			int s = Integer.parseInt(st.nextToken());
    			
    			start[i] = l;
    			end[i] = r;
    			num[i] = s;
    		}
    		
    		dfs(0);
    		
    		sb.append('#').append(tc).append(' ');
            if (maxSum == -1) {
                sb.append(-1);
            } else {
                for (int n : ans) sb.append(n).append(' ');
            }
            sb.append('\n');
        }
    	
    	System.out.print(sb);
    }
    static void dfs(int cnt) {
        if(cnt == N) {
        	for(int i=0; i<M; i++) {
        		int s = start[i];
        		int e = end[i];
        		int n = num[i];
        		
        		int segSum = 0;
        		for(int j=s; j<=e; j++) segSum += tmp[j];
        		if(segSum != n) return;
        	}
        	
        	int sum = 0;
        	for(int j=1; j<=N; j++) sum += tmp[j];
        	
        	if(sum > maxSum) {
        		maxSum = sum;
        		for(int k=1; k<=N; k++) ans[k-1] = tmp[k];
        	}
        	return;
        }
        
        int idx = cnt + 1;
        for(int i=0; i<=X; i++) {
        	tmp[idx] = hamNum[i];
        	dfs(cnt + 1);
        }
    }
}
