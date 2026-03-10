import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int homeX, homeY;
	static int[] cx, cy;
	static int ans;
	static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	
        	cx = new int[N];
        	cy = new int[N];
        	v = new boolean[N];
        	
        	st = new StringTokenizer(br.readLine());
        	
            int comX = Integer.parseInt(st.nextToken());
            int comY = Integer.parseInt(st.nextToken());
            
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            
            for(int i=0; i<N; i++) {
            	cx[i] = Integer.parseInt(st.nextToken());
            	cy[i] = Integer.parseInt(st.nextToken());
            }

            ans = Integer.MAX_VALUE;
            
            dfs(comX, comY, 0, 0);
            
            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }

        System.out.print(sb);
    }
    static void dfs(int x, int y, int sum, int cnt) {
    	if(cnt == N) {
    		ans = Math.min(ans, sum + calDist(x, y, homeX, homeY));
    		return;
    	}
    	
    	if(sum >= ans) return; // 거리가 이미 ans보다 크면 어처피 안되니까 가지치기
    	
    	for(int i=0; i<N; i++) {
    		if(v[i]) continue;
    		v[i] = true;
    		dfs(cx[i], cy[i], sum + calDist(x, y, cx[i], cy[i]), cnt + 1);
    		v[i] = false;
    	}
    }
    static int calDist(int lastX, int lastY, int x, int y) {
    	return Math.abs(lastX - x) + Math.abs(lastY - y);
    }
}
