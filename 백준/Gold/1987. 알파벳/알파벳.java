import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static int[][] map;
	static boolean[] v;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		v = new boolean[26];
		
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = line.charAt(j) - 'A';
			}
		}
		
		ans = 0;
		
		v[map[0][0]] = true;
		dfs(0, 0, 1);

		System.out.println(ans);
	}
	static void dfs(int x, int y, int cnt) {
		ans = Math.max(ans, cnt);
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k], ny = y + dy[k];
			
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			
			int nextNum = map[nx][ny];
			if(v[nextNum]) continue;
			
			if(!v[nextNum]) {
				v[nextNum] = true;
				dfs(nx, ny, cnt + 1);
				v[nextNum] = false;
			}
		}
	}
}
