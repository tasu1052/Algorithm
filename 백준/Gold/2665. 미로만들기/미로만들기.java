import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dist;
	static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N]; //0이 검은 방 1은 흰방
		dist = new int[N][N];
		for(int i=0; i<N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = (line.charAt(j) - '0') ^ 1; //이러면 이제 0이 흰방 1이 검은방
			}
		}
		
		bfs(0, 0);
		
		System.out.println(dist[N-1][N-1]);
	}
	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i, j});
		dist[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0], y = now[1];
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k], ny = y + dy[k];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				int nextCost = dist[x][y] + map[nx][ny];
				
				if(dist[nx][ny] > nextCost) {
					dist[nx][ny] = nextCost;
					
					if(map[nx][ny] == 0) q.addFirst(new int[] {nx, ny});
					else q.addLast(new int[] {nx, ny});
				}
			}
		}
	}
}
