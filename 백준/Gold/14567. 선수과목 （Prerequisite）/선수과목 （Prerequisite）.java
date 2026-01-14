import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	int cnt = 0;
	public static void main(String args[]) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st;
	 StringBuilder sb = new StringBuilder();
	 
	 st = new StringTokenizer(br.readLine());
	 int n = Integer.parseInt(st.nextToken());
	 int m = Integer.parseInt(st.nextToken());
	 
	 ArrayList<Integer> A[] = new ArrayList[n+1];
	 for(int i=0; i<=n; i++) A[i] = new ArrayList<>();
	 
	 int[] D = new int[n+1];
	 
	 for(int i=1; i<=m; i++) {
		 st = new StringTokenizer(br.readLine());
		 int s = Integer.parseInt(st.nextToken());
		 int e = Integer.parseInt(st.nextToken());
		 
		 A[s].add(e);
		 D[e]++;
	 }
	 
	 int[] ans = new int[n+1];
	 for(int i=1; i<=n; i++) ans[i] = 1;
	 int turn = 1;
	 
	 Queue<Integer> q = new LinkedList<>();
	 for(int i=1; i<=n; i++) {
		 if(D[i] == 0) {
			 q.offer(i);
			 ans[i] = turn;
		 }
	 }
	 
	 while(!q.isEmpty()) {
		 int now = q.poll();
		 
		 for(int next : A[now]) {
			 D[next]--;
			 if(D[next] == 0) {
				 q.offer(next);
			 }
			 ans[next] = ans[now] + 1;
		 }
	 }
	 for(int i=1; i<=n; i++) sb.append(ans[i] + " ");
	 System.out.print(sb);
	}
}