import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static int[] parent;
	static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            parent = new int[N+1];
            for(int i=1; i<=N; i++) parent[i] = i;

            for(int i=0; i<M; i++) {
            	st = new StringTokenizer(br.readLine());
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	
            	if(find(a) != find(b)) union(a, b);
            }
            
            ans = 0;
            for(int i=1; i<=N; i++) {
            	parent[i] = find(i);
            }
            
            boolean[] check = new boolean[N+1];
            for(int i=1; i<=N; i++) {
            	if(!check[i]) {
            		check[parent[i]] = true;
            	}
            }
            
            for(int i=1; i<=N; i++) {
            	if(check[i]) {
            		ans++;
            	}
            }
            
            
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.print(sb);
    }
    static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if(a != b) parent[b] = a;
    }
    static int find(int x) {
    	if(x == parent[x]) return x;
    	return parent[x] = find(parent[x]);
    }
}
