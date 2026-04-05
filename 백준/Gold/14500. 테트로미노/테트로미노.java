import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N, M;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(!visited[i][j]) {
        			visited[i][j] = true;
        			dfs(i, j, 1, map[i][j]);
        			visited[i][j] = false;
        		}
        	}
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		int pi = i + 1;
        		int mi = i - 1;
        		int pj = j + 1;
        		int mj = j - 1;
        		
        		if(pi < N && mi >= 0 && pj < M) {
        		    int rSum = map[i][j]
        		             + map[i][pj]
        		             + map[pi][j]
        		             + map[mi][j];
        		    max = Math.max(max, rSum);
        		}
        		
        		if(pi < N && mj >= 0 && pj < M) {
        			int dSum = map[i][j]
        					+ map[i][pj]
        					+ map[i][mj]
        					+ map[pi][j];
        			max = Math.max(max, dSum);
        		}	
        		
        		if(pj < M && mj >= 0 && mi >= 0) {
        			int uSum = map[i][j]
        					+ map[i][pj]
        					+ map[i][mj]
        					+ map[mi][j];
        			max = Math.max(max, uSum);
        		}	
        		
        		if(pi < N && mi >= 0 && mj >= 0) {
        			int lSum = map[i][j]
        					+ map[pi][j]
        					+ map[mi][j]
        					+ map[i][mj];
        			max = Math.max(max, lSum);
        		}
   
        	}
        }
        
        System.out.println(max);
    }
    static void dfs(int i, int j, int count, int sum) {
    	
    	if(count == 4) {
    		max = Math.max(sum, max);
    		visited[i][j] = false;
    		return;
    	}
    	
    	for(int k=0; k<4; k++) {
    		int x = i + dx[k];
    		int y = j + dy[k];
    		
    		if(x < 0 || x >= N || y < 0 || y >= M) continue;
    		if (visited[x][y]) continue;
    		
    		
    		visited[x][y] = true;
    		dfs(x, y, count + 1, sum + map[x][y]);
    		visited[x][y] = false;
    		
    	}
    	
    }
}