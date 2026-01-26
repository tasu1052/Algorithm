import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> A[] = new ArrayList[N+1];
		for(int i=0; i<=N; i++) A[i] = new ArrayList<>();
		int[] parent = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e);
			A[e].add(s);
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : A[now]) {
				if(!visited[next]) {
				parent[next] = now;
				visited[next] = true;
				q.add(next);
				}
			}
		}
		
		for(int i=2; i<=N; i++) sb.append(parent[i]).append('\n');
		
		System.out.println(sb);
	}
}
