import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> A[];
	static int cnt = 0;
	static int target;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		A = new ArrayList[N+1];
		for(int i=0; i<=N; i++) A[i] = new ArrayList<>();
		visited = new boolean[N+1];
		
		int root = -1;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num == -1) {
				root = i;
				continue;
			}
			A[num].add(i);
			A[i].add(num);
		}
		
		target = Integer.parseInt(br.readLine());
		
		if(target != root) dfs(root);
		
		System.out.println(cnt);
	}
	static void dfs(int r) {
		visited[r] = true;
		int cNode = 0;
		
		for(int next : A[r]) {
			if(next != target && !visited[next]) {
                cNode++;
				dfs(next);
				
			}
		}
		
		if(cNode == 0) cnt++;
	}
}
