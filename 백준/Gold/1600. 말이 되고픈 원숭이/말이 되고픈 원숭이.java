import java.io.*;
import java.util.*;

public class Main {
	static int K;
	static int W,H;
	static int[][] map;
	static int[][][] dist;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        map = new int[H][W];
        dist = new int[H][W][K+1];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        
        for(int i=0; i<H; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<W; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        System.out.println(bfs());
    }
    static int bfs() {
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	dist[0][0][0] = 0;
    	q.add(new int[] {0, 0, 0});
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int x = now[0], y = now[1], k = now[2];
    		
    		if(x == H-1 && y == W-1) return dist[x][y][k];
    		
    		for(int d=0; d<4; d++) {
    			int nx = x + dx[d], ny = y + dy[d];

    			if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
    			if(map[nx][ny] == 1) continue;
    			if(dist[nx][ny][k] != -1) continue;
    			
    			dist[nx][ny][k] = dist[x][y][k] + 1;
    			q.add(new int[] {nx, ny, k});
    		}
    		
    		if(k < K) {
    			for(int d=0; d<8; d++) {
        			int nx = x + hx[d], ny = y + hy[d];

        			if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
        			if(map[nx][ny] == 1) continue;
        			if(dist[nx][ny][k + 1] != -1) continue;
        			
        			dist[nx][ny][k+1] = dist[x][y][k] + 1;
        			q.add(new int[] {nx, ny, k+1});
        		}
    		}
    	}
    	return -1;
    }
}