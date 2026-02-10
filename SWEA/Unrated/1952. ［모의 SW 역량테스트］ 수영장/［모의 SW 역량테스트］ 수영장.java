import java.io.*;
import java.util.*;

public class Solution {
	static int[] tickets = new int[4];
    static int[] plans = new int[13];
    static int minCost;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++) tickets[i] = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<13; i++) plans[i] = Integer.parseInt(st.nextToken());
            
            minCost = tickets[3];
            
            dfs(1, 0);

            sb.append('#').append(tc).append(' ').append(minCost).append('\n');
        }
        System.out.println(sb);
    }
    
    static void dfs(int idx, int sum) {
    	if(sum > minCost) return;
    	
    	if(idx >= 13) {
    		minCost = Math.min(minCost, sum);
    		return;
    	}
    	
    	//해당 월은 1일 선택
    	dfs(idx + 1, sum +(plans[idx] * tickets[0]));
    	//한달 선택
    	dfs(idx + 1, sum + tickets[1]);
    	//3달 선택
    	dfs(idx + 3, sum + tickets[2]);
    }
}
