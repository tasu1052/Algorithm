import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            List<Integer>[] g = new ArrayList[N + 1];
            List<Integer>[] rg = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                g[i] = new ArrayList<>();
                rg[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                g[a].add(b);
                rg[b].add(a);
            }

            int ans = 0;
            for(int i=1; i<=N; i++) {
            	int bigger = bfs(i, g, N);
            	int smaller = bfs(i, rg, N);
            	
            	if(bigger + smaller == N-1) ans++;
            }
            

            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.print(sb);
    }
    
    static int bfs(int start, List<Integer>[] g, int N) {
    	boolean[] visited = new boolean[N+1];
    	    	
    	ArrayDeque<Integer> q = new ArrayDeque<>();
    	q.add(start);
    	visited[start] = true;
    	
    	int cnt = 0;
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		
    		for(int next : g[now]) {
    			if(!visited[next]) {
    				visited[next] = true;
    				q.add(next);
    				cnt++;
    			}
    		}
    	}
    	
    	return cnt;
    }
}
