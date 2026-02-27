import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];
            for(int i=0; i<N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
            
            for(int i=0; i<N; i++) {
            	String line = br.readLine();
            	for(int j=0; j<N; j++) {
            		map[i][j] = line.charAt(j) - '0';
            	}
            }
            
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.add(new int[] {0, 0});
            dist[0][0] = 0;
            
            while(!q.isEmpty()) {
            	int[] now = q.poll();
            	int x = now[0];
            	int y = now[1];
            	
            	for(int k=0; k<4; k++) {
            		int nx = x + dx[k];
            		int ny = y + dy[k];
            		
            		if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            		
            		if(dist[nx][ny] > dist[x][y] + map[nx][ny]) {
            			dist[nx][ny] = dist[x][y] + map[nx][ny];
            			q.add(new int[] {nx, ny});
            		}
            	}
            }

            sb.append('#').append(tc).append(' ').append(dist[N-1][N-1]).append('\n');
        }

        System.out.print(sb);
    }
}
