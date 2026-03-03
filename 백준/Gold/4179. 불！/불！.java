import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class Main {
	static int R, C;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static char[][] map;
	static int[][] fireTime;
	static int[][] personTime;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		fireTime = new int[R][C];
		personTime = new int[R][C];
		
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
            Arrays.fill(fireTime[i], -1);
        }

        fireBfs();

        boolean escaped = personBfs();

        if (!escaped) System.out.println("IMPOSSIBLE");
	}
	
	static void fireBfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] visitedFire = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'F') {
					q.add(new int[] {i, j});
					visitedFire[i][j] = true;
					fireTime[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if(visitedFire[nx][ny]) continue;
				if(map[nx][ny] == '#') continue;
				
				visitedFire[nx][ny] = true;
				fireTime[nx][ny] = fireTime[x][y] + 1;
				q.add(new int[] {nx, ny});
			}
		}
	}
	
	static boolean personBfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited = new boolean[R][C];
		
		int sx = -1, sy = -1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'J') {
                    sx = i; sy = j;
                    break;
                }
            }
            if (sx != -1) break;
        }

        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        personTime[sx][sy] = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				int nt = personTime[x][y] + 1;
				
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
					System.out.println(personTime[x][y] + 1);
					return true;
				}
				
				if(visited[nx][ny]) continue;
				if(map[nx][ny] == '#') continue;
				
				if(fireTime[nx][ny] != -1 && nt >= fireTime[nx][ny]) continue;
				
				visited[nx][ny] = true;
				personTime[nx][ny] = nt;
				q.add(new int[] {nx, ny});
			}
		}
		return false;
	}
}
