import java.io.*;
import java.util.*;

public class Solution {
	static int[] parent;
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
        	
        	ArrayList<Island> arr = new ArrayList<>();
        	for(int i=0; i<N-1; i++) {
        		for(int j=i; j<N; j++) {
        			double sum = E * (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
        			arr.add(new Island(i, j, sum));
        		}
        	}
        	
        	parent = new int[N];
        	for(int i=0; i<N; i++) parent[i] = i;
        	
            Collections.sort(arr);
            
            int edgeCnt = 0;
            int idx = 0;
            ans = 0.0;
            
            while(edgeCnt != N-1) {
            	Island tmp = arr.get(idx++);
            	
            	if(find(tmp.from) != find(tmp.to)) {
            		union(tmp.from, tmp.to);
            		edgeCnt++;
            		ans += tmp.weight;
            	}
            }
            
            sb.append("#").append(tc).append(" ").append(Math.round(ans)).append('\n');
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
class Island implements Comparable<Island>{
	int from, to;
	double weight;
	
	Island(int from, int to, double weight){
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Island o) {
		return Double.compare(weight, o.weight);
	}
}
