import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //세로
        N = Integer.parseInt(st.nextToken()); //가로
        K = Integer.parseInt(st.nextToken()); //k개의 직사각형

          visited = new boolean[M][N];
        
        for(int k=0; k<K; k++) {
        	st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	
        	for(int i=y1; i<y2; i++) {
        		for(int j=x1; j<x2; j++) {
        			visited[i][j] = true;
        		}
        	}
        }
        
        int ans = 0;
        for(int i=0; i<M; i++) {
        	for(int j=0; j<N; j++) {
        		if(!visited[i][j]) {
        			ans++;
        			arr.add(count(i, j));
        		}
        	}
        }
        
        Collections.sort(arr);
        
        for(int a : arr) sb.append(a).append(" ");
        
        System.out.println(ans);
        System.out.print(sb);
    }
    static int count(int i, int j) {
    	int cnt = 1;
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	visited[i][j] = true;
    	q.add(new int[] {i, j});
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int x = now[0], y = now[1];
    		
    		for(int k=0; k<4; k++) {
    			int nx = x + dx[k], ny = y + dy[k];
    			
    			if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
    			if(visited[nx][ny]) continue;
    			
    			visited[nx][ny] = true;
    			q.add(new int[] {nx, ny});
    			cnt++;
    		}
    	}
    	return cnt;
    }
}
