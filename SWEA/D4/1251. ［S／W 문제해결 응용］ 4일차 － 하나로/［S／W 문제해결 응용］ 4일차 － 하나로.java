import java.io.*;
import java.util.*;

public class Solution {
	static double ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	int[] x = new int[N];
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<N; i++) x[i] = Integer.parseInt(st.nextToken());
        	
        	int[] y = new int[N];
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<N; i++) y[i] = Integer.parseInt(st.nextToken());
        	
        	double E = Double.parseDouble(br.readLine());
        	
        	ArrayList<Island>[] arr = new ArrayList[N];
        	for(int i=0; i<N; i++) arr[i] = new ArrayList<>();
        	
        	for(int i=0; i<N-1; i++) {
        		for(int j=i+1; j<N; j++) {
        			double sum = E * (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
        			arr[i].add(new Island(j, sum));
        			arr[j].add(new Island(i, sum));
        		}
        	}
        	
        	boolean[] visited = new boolean[N];
            PriorityQueue<Island> q = new PriorityQueue<>();
            
            int cnt = 0;
            ans = 0.0;
            
            q.add(new Island(0, 0));
            
            while(!q.isEmpty()) {
            	Island tmp = q.poll();
            	
            	if(visited[tmp.to]) continue;
            	
            	visited[tmp.to] = true;
            	ans += tmp.weight;
            	cnt++;
            	
            	
            	if(cnt == N) break;
            	
            	for(Island next : arr[tmp.to]) {
            		if(!visited[next.to]) {
            			q.add(new Island(next.to, next.weight));
            		}
            	}
            }
            
            sb.append("#").append(tc).append(" ").append(Math.round(ans)).append('\n');
        }

        System.out.print(sb);
    }
}
class Island implements Comparable<Island>{
	int to;
	double weight;
	
	Island(int to, double weight){
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Island o) {
		return Double.compare(weight, o.weight);
	}
}
