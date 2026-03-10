import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, K;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int ans;
	static micro[][] map;
	static ArrayDeque<micro> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            q = new ArrayDeque<>();
            
            for(int i=0; i<K; i++) {
            	st = new StringTokenizer(br.readLine());
            	int x = Integer.parseInt(st.nextToken());
            	int y = Integer.parseInt(st.nextToken());
            	int num = Integer.parseInt(st.nextToken());
            	int dir = Integer.parseInt(st.nextToken()) - 1;
            	
            	q.add(new micro(x, y, num, dir));
            }
            
            ans = 0;
            
            for(int i=0; i<M; i++) bfs();
            
            while(!q.isEmpty()) ans += q.poll().num;
            
            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }

        System.out.print(sb);
    }
    static void bfs() {
    	micro[][] map = new micro[N][N];
    	int[][] max = new int[N][N];
    	
    	while(!q.isEmpty()) {
    		micro tmp = q.poll();
    		int x = tmp.x, y = tmp.y, num = tmp.num, dir = tmp.dir;
    		
    		int nx = x + dx[dir], ny = y + dy[dir];
    		
    		if(nx == 0 || nx == N-1 || ny == 0 || ny == N-1) {
    			num /= 2;
    			dir = dir ^ 1;
    			if(num == 0) continue;
    		}
    		
    		if(map[nx][ny] != null) {
    			map[nx][ny].num += num;
    			if(max[nx][ny] < num) {
    				max[nx][ny] = num;
    				map[nx][ny].dir = dir;
    			}
    		}
    		else if(map[nx][ny] == null) {
    			map[nx][ny] = new micro(nx, ny, num, dir);
    			max[nx][ny] = num;
    		}
    	}
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(map[i][j] != null) {
    				q.add(map[i][j]);
    			}
    		}
    	}
    }
}
class micro{
	int x, y, num, dir;
	
	micro(int x, int y, int num, int dir){
		this.x = x;
		this.y = y;
		this.num = num;
		this.dir = dir;
	}
}
