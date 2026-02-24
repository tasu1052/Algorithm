import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Node>[] A;
	static ArrayList<Node>[] B;
	static int N;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //학생 수
		int M = Integer.parseInt(st.nextToken()); //도로 개수
		int X = Integer.parseInt(st.nextToken()); //시작 마을
		
		
		A = new ArrayList[N+1];
		for(int i=0; i<=N; i++) A[i] = new ArrayList<>();
		
		B = new ArrayList[N+1];
		for(int i=0; i<=N; i++) B[i] = new ArrayList<>();

		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			A[s].add(new Node(e, c));
			B[e].add(new Node(s, c));
		}
		
		int max = Integer.MIN_VALUE;
		
		int[] go = dijkstra(A, X);
		int[] back = dijkstra(B, X);
		
		for(int i=1; i<=N; i++) max = Math.max(max, go[i] + back[i]);
		
		System.out.println(max);
	}
	static int[] dijkstra(List<Node>[] graph, int start) {
		visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		dist[start] = 0;
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
			
			for(Node next : graph[cur.to]) {
				if(dist[next.to] > dist[cur.to] + next.cost) {
					dist[next.to] = dist[cur.to] + next.cost;
					q.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}
}
class Node implements Comparable<Node>{
	int to;
	int cost;
	
	Node(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(cost, o.cost);
	}
}
