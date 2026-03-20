import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] map;
	static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];   
        dist = new int[N][M];
        for(int i=0; i<N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        for(int i=0; i<N; i++) {
        	String line = br.readLine();
        	for(int j=0; j<M; j++) {
        		map[i][j] = line.charAt(j) - '0';
        	}
        }
        
        zeroBfs(0, 0);

        System.out.print(dist[N-1][M-1]);
    }
    static void zeroBfs(int i, int j) {
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	dist[0][0] = 0;
    	q.add(new int[] {i, j});
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int x = now[0], y = now[1];
    		
    		for(int k=0; k<4; k++) {
    			int nx = x + dx[k], ny = y + dy[k];
    			
    			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
    			
    			if(dist[nx][ny] > dist[x][y] + map[nx][ny]) {
    				dist[nx][ny] = dist[x][y] + map[nx][ny];
    				
    				if(map[nx][ny] == 0) q.addFirst(new int[] {nx, ny});
    				else q.addLast(new int[] {nx, ny});
    			}
    		}
    	}
    }
}
