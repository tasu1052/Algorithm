import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Node>[] A;
	static int N, M;
	static int[] dist;
	static boolean[] visited;
	static int[] items;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //지역의 개수
		M = Integer.parseInt(st.nextToken()); //수색 범위
		int R = Integer.parseInt(st.nextToken()); //길의 개수
		
		
		A = new ArrayList[N+1];
		for(int i=0; i<=N; i++) A[i] = new ArrayList<>();
		
		int max = Integer.MIN_VALUE;
		
		items = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) items[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=R; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			A[s].add(new Node(e, c));
			A[e].add(new Node(s, c));
		}
		
		for(int i=1; i<=N; i++) {
			max = Math.max(max, dijkstra(A, i));
		}
		
		
		
		System.out.println(max);
	}
	static int dijkstra(List<Node>[] graph, int start) {
		visited = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		int itemNum = 0;
		
		dist[start] = 0;
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
			
			if(dist[cur.to] == Integer.MAX_VALUE) continue;
			
			for(Node next : graph[cur.to]) {
				if(dist[next.to] > dist[cur.to] + next.cost) {
					dist[next.to] = dist[cur.to] + next.cost;
					q.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(dist[i] <= M) itemNum += items[i];
		}
		
		
		return itemNum;
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
