import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] map;
	static int[] dx = {0 ,1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        dist = new int[N][M][K+1];
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		Arrays.fill(dist[i][j], -1);
        	}
        }
        
        
        for(int i=0; i<N; i++) {
        	String line = br.readLine();
        	for(int j=0; j<M; j++) {
        		map[i][j] = line.charAt(j) - '0';
        	}
        }
        
        bfs(0, 0, 0);
        
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<=K; i++) {
        	if(dist[N-1][M-1][i] != -1) {
        		ans = Math.min(ans, dist[N-1][M-1][i]);
        	}
        }
        
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    static void bfs(int i, int j, int b) {
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	dist[i][j][b] = 1;
    	q.add(new int[] {i, j, b});
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int x = now[0], y = now[1], broken = now[2];
    		
    		for(int k=0; k<4; k++) {
    			int nx = x + dx[k], ny = y + dy[k];
    			
    			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
    			
    			if(map[nx][ny] == 0 && dist[nx][ny][broken] == -1) {
    				dist[nx][ny][broken] = dist[x][y][broken] + 1;
    				q.add(new int[] {nx, ny, broken});
    			}
    			
    			if(map[nx][ny] == 1 && broken < K && dist[nx][ny][broken + 1] == -1) {
    				dist[nx][ny][broken + 1] = dist[x][y][broken] + 1;
    				q.add(new int[] {nx, ny, broken + 1});
    			}
    		}
    	}
    }
}