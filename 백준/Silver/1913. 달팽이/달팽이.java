import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int find = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		int num = N * N;
		int x = 0, y = 0;
		int dir = 0;
		while(num > 0) {
			map[x][y] = num;
			num--;
			
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx < 0 || nx == N || ny < 0 || ny == N || map[nx][ny] != 0) {
				dir = (dir + 1) % 4;
				nx = x + dx[dir];
				ny = y + dy[dir];
			}
			
			x = nx;
			y = ny;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append('\n');
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == find) {
					sb.append(i + 1).append(" ").append(j + 1).append('\n');
				}
			}
		}
		
		System.out.println(sb);
	}
}
