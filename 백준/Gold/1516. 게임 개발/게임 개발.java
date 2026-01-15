import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st;
	 StringBuilder sb = new StringBuilder();
	 
	 int n = Integer.parseInt(br.readLine());
	 
	 ArrayList<Integer> A[] = new ArrayList[n+1];
	 for(int i=0; i<=n; i++) A[i] = new ArrayList<>();
	 
	 int[] D = new int[n+1];
	 int[] time = new int[n+1];
	 
	 for(int i=1; i<=n; i++) {
		 st = new StringTokenizer(br.readLine());
		 int buildTime = Integer.parseInt(st.nextToken());
		 time[i] = buildTime;

		 while(true) {
			 int num = Integer.parseInt(st.nextToken());
			 
			 if(num == -1) break;
			 
			 A[num].add(i);
			 D[i]++;
		 }
	 }
	 
	 int[] dp = new int[n+1];
	 for(int i=1; i<=n; i++) dp[i] = time[i];
	 
	 Queue<Integer> q = new LinkedList<>();
	 for(int i=1; i<=n; i++) {
		 if(D[i] == 0) {
			 q.offer(i);
		 }
	 }
	 
	 while(!q.isEmpty()) {
		 int now = q.poll();
		 
		 for(int next : A[now]) {
			 D[next]--;
			 dp[next] = Math.max(dp[next], dp[now] + time[next]);
			 if(D[next] == 0) {
				 q.offer(next);
			 }
		 }
	 }
	 
	 for(int i=1; i<=n; i++) sb.append(dp[i]).append('\n');
	 System.out.print(sb);
	}
}