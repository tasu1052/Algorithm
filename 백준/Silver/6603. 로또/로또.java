import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int[] arr;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
        	st = new StringTokenizer(br.readLine());
        	k = Integer.parseInt(st.nextToken());
        	
        	if(k == 0) break;
        	
        	arr = new int[k];
        	v = new boolean[k];
        	for(int i=0; i<k; i++) arr[i] = Integer.parseInt(st.nextToken());
        	
        	dfs(0, 0);
        	sb.append('\n');
        }
        
        System.out.println(sb);
    }
    static void dfs(int idx, int cnt) {
    	if(cnt == 6) {
    		for(int i=0; i<k; i++) {
    			if(v[i]) {
    				sb.append(arr[i]).append(" ");
    			}
    		}
    		sb.append('\n');
    		return;
    	}
    	
    	if(idx >= k) return;
    	
    	v[idx] = true;
    	dfs(idx + 1, cnt + 1);
    	
    	v[idx] = false;
    	dfs(idx + 1, cnt);
    }
}