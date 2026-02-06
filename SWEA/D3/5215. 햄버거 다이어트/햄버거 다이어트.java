import java.io.*;
import java.util.*;

public class Solution {
	static int N, K;
	static long best;
	static int[][] ingredient;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken()); //재료 수
        	K = Integer.parseInt(st.nextToken()); //칼로리 제한
        	
        	best = 0;
        	ingredient = new int[N][2];
        	
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		int score = Integer.parseInt(st.nextToken());
        		int cal = Integer.parseInt(st.nextToken());
        		
        		ingredient[i][0] = score;
        		ingredient[i][1] = cal;
        	}
        	
        	dfs(0, 0, 0);
        	
        	sb.append("#").append(tc).append(" ").append(best).append('\n');
        }
        System.out.println(sb);
	}
	
	static void dfs(int cnt, int score, int cal) {
		if(cal > K) return; //제한 칼로리 보다 높으면 가지치기
		
		if(cnt == N) {
			best = Math.max(best, score);
			return;
		}
		
		dfs(cnt + 1, score + ingredient[cnt][0], cal + ingredient[cnt][1]); 
		//해당 재료 선택하고 가는 경우
		
		dfs(cnt + 1, score, cal); //해당 재료 선택 안하고 가는 경우
	}

}
