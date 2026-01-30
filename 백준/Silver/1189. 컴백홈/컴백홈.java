import java.io.*;
import java.util.*;

public class Main {
	static int R, C, K;
	static char[][] map;
	static boolean[][] visited;
	static int cnt = 0;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		visited[R-1][0] = true;
		dfs(R-1, 0, 1);
		
		System.out.println(cnt);
	}
	static void dfs(int i, int j, int depth) {
		if(i == 0 && j == C-1) {
			if(depth == K) {
				cnt++;
				return;
			}
			return;
		}
		
		
		for(int k=0; k<4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			
			if(x < 0 || x >= R || y < 0 || y >= C) continue;
			
			if(!visited[x][y] && map[x][y] == '.') {
				visited[x][y] = true;
				dfs(x, y, depth + 1);
				visited[x][y] = false;
			}
		}
	}
}