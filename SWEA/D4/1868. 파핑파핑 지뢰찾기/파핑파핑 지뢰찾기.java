import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static char[][] map;
	static boolean[][] v;
	static int[][] bombNum;
	static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            
            map = new char[N][N];
            v = new boolean[N][N];
            bombNum = new int[N][N];
            ans = 0;
            
            for(int i=0; i<N; i++) Arrays.fill(bombNum[i], -1);
            
            for(int i=0; i<N; i++) {
            	String s = br.readLine();
            	for(int j=0; j<N; j++) {
            		map[i][j] = s.charAt(j);
            		if(map[i][j] == '.') bombNum[i][j] = 0;
            	}
            }
            
            for(int i=0; i<N; i++) {
            	for(int j=0; j<N; j++) {
            		if(map[i][j] == '.') {
	            		for(int d=0; d<8; d++) {
	            			int nx = i + dx[d];
	            			int ny = j + dy[d];
	            			
	            			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
	            			
	            			if(map[nx][ny] == '*') bombNum[i][j]++;
	            		}
	            	}
            	}
            }
            
            for(int i=0; i<N; i++) { //먼저 0인부분 bfs
            	for(int j=0; j<N; j++) {
            		if(bombNum[i][j] == 0 && !v[i][j]) {
            			bfs(i, j);
            			ans++;
            		}
            	}
            }
            
            for(int i=0; i<N; i++) { //아직 방문 안한곳 bfs
            	for(int j=0; j<N; j++) {
            		if(bombNum[i][j] != -1 && !v[i][j]) {
            			ans++;
            		}
            	}
            }
            
            
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.print(sb);
    }
    static void bfs(int i, int j) {
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	v[i][j] = true;
    	q.add(new int[] {i, j});
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int x = now[0], y = now[1];
    		
    		for(int k=0; k<8; k++) {
    			int nx = x + dx[k], ny = y + dy[k];
    			
    			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
    			
    			if(!v[nx][ny] && bombNum[nx][ny] == 0) {
    				v[nx][ny] = true;
    				q.add(new int[] {nx, ny});
    			}
    			else if(!v[nx][ny] && bombNum[nx][ny] != 0) {
    				v[nx][ny] = true;
    			}
    		}
    	}
    }
}
