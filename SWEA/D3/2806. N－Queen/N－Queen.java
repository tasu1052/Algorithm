import java.io.*;
import java.util.*;

public class Solution {
	static int N, cnt;
	static boolean[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            
            cnt = 0;
            arr = new boolean[N][N];
            
            dfs(0);

            sb.append('#').append(tc).append(' ').append(cnt).append('\n');
        }
        System.out.println(sb);
    }
    
    static void dfs(int idx) {
    	if(idx == N) {
    		cnt++;
    		return;
    	}
    	
    	for(int i=0; i<N; i++) {
    		if(isSafte(idx, i)) {
    			arr[idx][i] = true;
    			dfs(idx + 1);
    			arr[idx][i] = false;
    		}
    	}
    }
    
    static boolean isSafte(int row, int col) {
    	for(int i=0; i<row; i++) {
    		if(arr[i][col]) return false;
    	}
    	
    	for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
    		if(arr[i][j]) return false;
    	}
    	
    	for(int i=row-1, j=col+1; i>=0 && j<N; i--, j++) {
    		if(arr[i][j]) return false;
    	}
    	
    	return true;
    }
}
