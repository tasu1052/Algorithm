import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T= Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            
            ArrayList<Edge> list = new ArrayList<>();
            int[] dist = new int[N+1];
            Arrays.fill(dist, 0);
            
            for(int i=0; i<M; i++) {
            	st = new StringTokenizer(br.readLine());
            	int s = Integer.parseInt(st.nextToken());
            	int e = Integer.parseInt(st.nextToken());
            	int t = Integer.parseInt(st.nextToken());
            	
            	list.add(new Edge(s, e, t));
            	list.add(new Edge(e, s, t));
            }
            
            for(int i=0; i<W; i++) {
            	st = new StringTokenizer(br.readLine());
            	int s = Integer.parseInt(st.nextToken());
            	int e = Integer.parseInt(st.nextToken());
            	int t = -(Integer.parseInt(st.nextToken()));
            	
            	list.add(new Edge(s, e, t));
            }
            
            for(int i=1; i<N; i++) {
            	for(Edge e : list) {
            		if(dist[e.end] > dist[e.start] + e.weight) {
            			dist[e.end] = dist[e.start] + e.weight;
            		}
            	}
            }
            
            boolean check = true;
            for(Edge e : list) {
            	if(dist[e.end] > dist[e.start] + e.weight) {
        			dist[e.end] = dist[e.start] + e.weight;
        			check = false;
        			break;
        		}
            }
            
            if(check) {
            	sb.append("NO\n");
            }
            else sb.append("YES\n");
            
        }
        
        System.out.print(sb);
    }
}
class Edge{
	int start;
	int end;
	int weight;
	
	Edge(int start, int end, int weight){
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}