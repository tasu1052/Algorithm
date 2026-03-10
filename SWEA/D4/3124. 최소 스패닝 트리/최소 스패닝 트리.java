import java.io.*;
import java.util.*;

public class Solution {
	static ArrayList<Node> arr;
	static int[] parent;
	static long ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            arr = new ArrayList<>();
            parent = new int[V+1];
            
            for(int i=0; i<E; i++) {
            	st = new StringTokenizer(br.readLine());
            	int f = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                
                arr.add(new Node(f, t, w));
            }
            
            for(int i=1; i<=V; i++) parent[i] = i;
            
            Collections.sort(arr);
            
            int edgeCnt = 0;
            int idx = 0;
            ans = 0;
            
            while(edgeCnt < V-1) {
            	Node tmp = arr.get(idx++);
            	
            	if(find(tmp.from) != find(tmp.to)) {
            		union(tmp.from, tmp.to);
            		ans += tmp.weight;
            		edgeCnt++;
            	}
            }
            
            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }

        System.out.print(sb);
    }
    static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if(a != b) parent[b] = a;
    }
    static int find(int x) {
    	if (x == parent[x]) return x;
    	return parent[x] = find(parent[x]);
    }
}
class Node implements Comparable<Node>{
	int from, to, weight;
	
	Node(int from, int to, int weight){
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(weight, o.weight);
	}
}
