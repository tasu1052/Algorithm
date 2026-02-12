import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static long ans;
	static int[][] map;
	static int maxCnt, startNum;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            
            map = new int[N][N];
            
            for(int i=0; i<N; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j=0; j<N; j++) {
            		map[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            int[][] startArr = new int[N][N];
            maxCnt = 0;
            startNum = Integer.MAX_VALUE;
            for(int i=0; i<N; i++) {
            	for(int j=0; j<N; j++) {
            		startArr[i][j] = bfs(i, j);
            	}
            }
            
            for(int i=0; i<N; i++) {
            	for(int j=0; j<N; j++) {
            		if(startArr[i][j] == maxCnt) {
            			startNum = Math.min(startNum, map[i][j]);
            		}
            	}
            }
            sb.append('#').append(tc).append(' ').append(startNum)
            .append(' ').append(maxCnt).append('\n');
        }
        System.out.println(sb);
    }

    static int bfs(int i, int j) {
    	int cnt = 0;
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {i, j});
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		cnt++;
    		
    		for(int k=0; k<4; k++) {
    			int nx = cur[0] + dx[k];
    			int ny = cur[1] + dy[k];
    			
    			if(nx >= 0 && nx < N && ny >= 0 && ny < N 
    					&& map[nx][ny] == map[cur[0]][cur[1]] + 1) {
    				q.add(new int[] {nx, ny});
    			}
    		}
    	}
    	maxCnt = Math.max(maxCnt, cnt);
    	return cnt;
    }
}
