import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int minTime = Integer.MAX_VALUE;
	static int cnt = 0;
	static int[] dist = new int[100001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dist, -1);
		
		bfs(N, K);
		
		System.out.println(minTime);
		System.out.println(cnt);
	}
	static void bfs(int start, int target) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {start, 0});
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			int nowNum = now[0];
			int time = now[1];
			
			if(time > minTime) continue;
			
			if(nowNum == target) {
				minTime = time;
				cnt++;
				continue;
			}
			
			for(int k=0; k<3; k++) {
				int next = 0;
				
				if(k == 0) next = nowNum - 1;
				else if(k == 1) next = nowNum + 1;
				else next = nowNum * 2;
				
				if(next < 0 || next > 100_000) continue;
				
				if(dist[next] == -1 || dist[next] == time + 1) {
					dist[next] = time + 1;
					q.add(new int[] {next, time + 1});
				}
				
			}
		}
	}
}
