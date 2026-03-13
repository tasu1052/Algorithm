import java.io.*;
import java.util.*;

public class Solution {
	static String[][] map;
	static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static HashSet<String> hs;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			map = new String[4][4];
			
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					map[i][j] = st.nextToken();
				}
			}
			
			hs = new HashSet<>();
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					dfs(i, j, 0, map[i][j]);
				}
			}
			
			sb.append('#').append(tc).append(' ').append(hs.size()).append('\n');
		}
		
		System.out.println(sb);
	}
	static void dfs(int x, int y, int cnt, String s) {
		if(cnt == 6) {
			if(!hs.contains(s)) {
				hs.add(s);
			}
			return;
		}
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k], ny = y + dy[k];
			
			if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
			
			dfs(nx, ny, cnt + 1, s + map[nx][ny]);
		}
	}
}
