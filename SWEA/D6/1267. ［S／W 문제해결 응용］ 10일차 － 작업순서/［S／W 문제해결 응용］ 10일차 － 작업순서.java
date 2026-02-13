import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 10;//Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	int V = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	
        	List<Integer>[] A = new List[V+1];
        	for(int i=0; i<=V; i++) A[i] = new ArrayList<>();
        	
        	int[] D = new int[V+1];
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<E; i++) {
        		int s = Integer.parseInt(st.nextToken());
        		int e= Integer.parseInt(st.nextToken());
        		
        		A[s].add(e);
        		D[e]++;
        	}
        	
        	ArrayDeque<Integer> q = new ArrayDeque<>();
        	sb.append('#').append(tc).append(' ');
        	
        	//System.out.println(Arrays.toString(D));
        	for(int i=1; i<=V; i++) {
        		if(D[i] == 0) q.add(i);
        	}
        	
            while(!q.isEmpty()) {
            	int now = q.poll();
            	
            	sb.append(now).append(' ');
            	
            	for(int next : A[now]) {
            		D[next]--;
            		if(D[next] == 0) q.add(next);
            	}
            }
            
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
