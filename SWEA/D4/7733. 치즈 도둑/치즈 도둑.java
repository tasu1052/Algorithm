import java.io.*;
import java.util.*;
 
public class Solution {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();
              
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	map = new int[N][N];
        	
        	max = 0;
        	
        	int tmpMax = Integer.MIN_VALUE;
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        			tmpMax = Math.max(tmpMax, map[i][j]);
        		}
        	}

        	
        	for(int c=0; c<=tmpMax; c++) {
        		visited = new boolean[N][N];
        		for(int i=0; i<N; i++) {
        			for(int j=0; j<N; j++) {
        				if(map[i][j] == c) map[i][j] = 0; //맵 돌면서 그날 먹어버린 치즈 처리
        			}
        		}
        		int sum = 0;
        		for(int i=0; i<N; i++) {
        			for(int j=0; j<N; j++) {
        				if(!visited[i][j] && map[i][j] != 0) {
        					sum += bfs(i, j);
        				}
        			}
        		}
        		max = Math.max(max, sum);
        	}
        	
        	sb.append("#").append(tc).append(" ").append(max).append('\n');
        }
        System.out.println(sb);
	}

	static int bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(new int[] {i, j});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int k=0; k<4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				
				if(x < 0 || x >= N || y < 0 || y >= N) continue;
				
				if(!visited[x][y] && map[x][y] != 0) {
					visited[x][y] = true;
					q.offer(new int[] {x, y});
				}
			}
		}
		return 1;
	}
}
