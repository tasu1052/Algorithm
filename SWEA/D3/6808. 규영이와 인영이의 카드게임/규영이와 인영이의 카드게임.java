import java.io.*;
import java.util.*;
 
public class Solution {
	static int winCnt, loseCnt;
	static boolean[] visited;
	static int[] gCards, iCards;
	static int N = 9, R = 9;
	static int[] permArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++){
        	gCards = new int[9];
        	iCards = new int[9];
        	visited = new boolean[9];
        	permArr = new int[9];
        	winCnt = 0;
        	loseCnt = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<9; i++) gCards[i] = Integer.parseInt(st.nextToken());
            
            boolean[] used = new boolean[19];
            for(int x : gCards) used[x] = true;
            
            int idx = 0;
            for(int i=1; i<=18; i++) {
            	if(!used[i]) iCards[idx++] = i;
            }
            
            perm(0);

            sb.append("#").append(t).append(" ").append(winCnt).append(" ").append(loseCnt).append('\n');
        }
        System.out.print(sb);
    }
    static void perm(int cnt) {
    	if(cnt == R) {
    		int gSum = 0;	//총점
    		int iSum = 0;
    		for(int i=0; i<N; i++) {
    			if(gCards[i] > permArr[i]) {
    				gSum += gCards[i] + permArr[i];
    			} else if(gCards[i] < permArr[i]) {
    				iSum += gCards[i] + permArr[i];
    			}
    		}
    		if(gSum > iSum) winCnt++;
    		else if(gSum < iSum) loseCnt++;
    		return;
    	}
    	for(int i=0; i<N; i++) {
    		if(visited[i]) continue;
    		visited[i] = true;
    		permArr[cnt] = iCards[i];
    		perm(cnt + 1);
    		visited[i] = false;
    	}
    }
}