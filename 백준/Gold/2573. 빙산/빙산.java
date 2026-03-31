import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        dfs(1);
    }
    static void dfs(int year) {
    	int[][] result = new int[N][M];
    	for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(map[i][j] != 0) {
        			int tmp = 0;
        			for(int k=0; k<4; k++) {
        				int nx = i + dx[k], ny = j + dy[k];
        				
        				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        				
        				if(map[nx][ny] == 0) tmp++;
        			}
        			result[i][j] = tmp;
        		}
        	}
        }
    	
    	for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(result[i][j] != 0) {
        			int nextMapNum = map[i][j] - result[i][j];
        			map[i][j] = nextMapNum > 0 ? nextMapNum : 0;
        		}
        	}
        }
    	
//    	for(int[] a : map) System.out.println(Arrays.toString(a));
//    	System.out.println();
    	
    	int icebergNum = 0;
    	
    	icebergNum = check();
    	
    	if(icebergNum >= 2) { //빙하의 개수가 2개 이상이면 year을 출력하고 종료
    		System.out.println(year);
    		return;
    	}
    	
    	if(empty()) { //빙하가 분리 안된 상태에서 전부 녹았다면 0출력 후 종료
    		System.out.println(0);
    		return;
    	}
    	
    	dfs(year + 1);
    	
    }
    static int check() {
    	visited = new boolean[N][M];
    	int cnt = 0;
    	
    	for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(map[i][j] != 0 && !visited[i][j]) {
        			bfs(i, j);
        			cnt++;
        		}
        	}
        }
    	return cnt;
    }
    static void bfs(int i, int j) {
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	visited[i][j] = true;
    	q.add(new int[] {i, j});
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int x = now[0], y = now[1];
    		
    		for(int k=0; k<4; k++) {
    			int nx = x + dx[k], ny = y + dy[k];
    			
    			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
    			if(visited[nx][ny]) continue;
    			if(map[nx][ny] == 0) continue;
    			
    			visited[nx][ny] = true;
    			q.add(new int[] {nx, ny});
    			
    		}
    		
    	}
    }
    static boolean empty() { //모든 빙하가 전부 녹았다면 true반환하는 함수
    	for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(map[i][j] != 0) return false;
        	}
        }
    	return true;
    }
}