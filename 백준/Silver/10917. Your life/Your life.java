import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> A[];
	static boolean[] visited;
	static int cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		for(int i=0; i<=N; i++) A[i] = new ArrayList<>();
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			A[x].add(y);
		}
	
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {1, 0});
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			if(now[0] == N) {
				System.out.println(now[1]);
				return;
			}
			
			for(int next : A[now[0]]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(new int[] {next, now[1] + 1});
				}
			}
		}
		System.out.println(-1);
	}
}