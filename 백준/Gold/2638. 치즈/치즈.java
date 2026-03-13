import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] check;
	static int ans = 0;
	static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] needMelt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(map, 0);
		
		System.out.println(ans);
	}
	static void dfs(int[][] map, int time) {
		if(isClear(map)) {
			ans = time;
			return;
		}
		
		markOuterAir();
		
		needMelt = new boolean[N][M];
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(map[i][j] == 1) {
					checkMelt(i, j);
				}
			}
		}
		
		melt();
		
		dfs(map, time + 1);
	}
	static boolean isClear(int[][] map) {
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}
	static void markOuterAir() {
	    check = new boolean[N][M];
	    ArrayDeque<int[]> q = new ArrayDeque<>();
	    q.add(new int[] {0, 0});
	    check[0][0] = true;

	    while(!q.isEmpty()) {
	        int[] now = q.poll();
	        int x = now[0], y = now[1];

	        for(int k=0; k<4; k++) {
	            int nx = x + dx[k], ny = y + dy[k];

	            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
	            if(check[nx][ny]) continue;
	            if(map[nx][ny] == 1) continue;

	            check[nx][ny] = true;
	            q.add(new int[] {nx, ny});
	        }
	    }
	}
	static void checkMelt(int i, int j) {
		int cnt = 0;
		
		for(int k=0; k<4; k++) {
			int nx = i + dx[k], ny = j + dy[k];
			
			if(map[nx][ny] == 0 && check[nx][ny]) cnt++;
		}
		
		if(cnt >= 2) {
			needMelt[i][j] = true;
		}
	}
	static void melt() {
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(needMelt[i][j]) {
					map[i][j] = 0;
				}
			}
		}
	}
}
