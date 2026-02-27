import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
	static int N, M;
	static ArrayList<Integer>[] A, B;
	static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            
            A = new ArrayList[N+1];
            for(int i=0; i<=N; i++) A[i] = new ArrayList<>();
            
            B = new ArrayList[N+1];
            for(int i=0; i<=N; i++) B[i] = new ArrayList<>();
            
            ans = 0;
            
            for(int i=0; i<M; i++) {
            	st = new StringTokenizer(br.readLine());
            	int s = Integer.parseInt(st.nextToken());
            	int e = Integer.parseInt(st.nextToken());
            	
            	A[s].add(e);
            	B[e].add(s);
            }
            
            for(int i=1; i<=N; i++) {
            	boolean[] v = new boolean[N+1];
            	
            	bfs(i, v, A);
            	bfs(i, v, B);
            	
            	boolean check = true;
            	for(int j=1; j<=N; j++) {
            		if(!v[j]) {
            			check = false;
            			break;
            		}
            	}
            	
            	if(check) ans++;
            }
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.print(sb);
    }
    static void bfs(int start, boolean[] v, ArrayList<Integer>[] list) {
    	ArrayDeque<Integer> q = new ArrayDeque<>();
    	q.add(start);
    	v[start] = true;
    	
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		
    		for(int next : list[now]) {
	    			if(!v[next]) {
	    			v[next] = true;
	    			q.add(next);
	    		}
    		}
    	}
    }
}
