import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int ans;
	static ArrayList<int[]> virusList = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) virusList.add(new int[] {i, j});
			}
		}
		
		ans = 0;
		
		dfs(0, 3);

		System.out.println(ans);
	}
	static void dfs(int start, int wallCnt) {
		if(wallCnt == 0) {
			ans = Math.max(ans, virus());
			return;
		}
		
		for(int idx = start; idx < N * M; idx++) {
			int x = idx / M;
			int y = idx % M;
			
			if(map[x][y] == 0) {
				map[x][y] = 1;
				dfs(idx, wallCnt - 1);
				map[x][y] = 0;
			}
		}
	}
	static int virus() {
		boolean[][] visited = new boolean[N][M];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		for(int[] v : virusList) {
			q.add(new int[] {v[0], v[1]});
			visited[v[0]][v[1]] = true;
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0], y = now[1];
			visited[x][y] = true;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k], ny = y + dy[k];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if(!visited[nx][ny] && map[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0 && !visited[i][j]) cnt++;
			}
		}
		
		return cnt;
	}
}
