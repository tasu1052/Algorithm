import java.io.*;
import java.util.*;
 
public class Solution {
	static int N;
	static int[][] map;
	static List<int[]> cores;
	static int bestConnect, bestLen;
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
        	cores = new ArrayList<>(); //코어 개수 저장
        	
        	for(int i=0; i<N; i++) { //맵 초기화
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        			if(map[i][j] == 1) {
        				if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                            cores.add(new int[]{i, j});
                        }
        			}
        		}
        	}
        	
        	bestConnect = -1;
        	bestLen = Integer.MAX_VALUE;
        	
        	dfs(0, 0, 0);	
        	
        	sb.append("#").append(tc).append(" ").append(bestLen).append('\n');
        }
        System.out.println(sb);
	}
	
	static void dfs(int idx, int connected, int len) {
		int remain = cores.size() - idx;
		
		if(connected + remain < bestConnect) return;
		
		if(connected + remain == bestConnect && len >= bestLen) return;
		
		if(idx == cores.size()) {
			if(connected > bestConnect) {
				bestConnect = connected;
				bestLen = len;
			} else if(connected == bestConnect) {
				bestLen = Math.min(bestLen, len);
			}
			return;
		}
		
		int x = cores.get(idx)[0];
		int y = cores.get(idx)[1];
		
		for(int dir=0; dir<4; dir++) {
			int need = canConnect(x, y, dir);
			if(need == -1) continue;
			
			setWire(x, y, dir, 2, need);
			dfs(idx + 1, connected + 1, len + need);
			setWire(x, y, dir, 0, need);
		}
		
		dfs(idx + 1, connected, len);
	}
	
	static int canConnect(int x, int y, int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		int cnt = 0;
		
		while (0 <= nx && nx < N && 0 <= ny && ny < N) {
            if (map[nx][ny] != 0) return -1; // 코어(1) 또는 전선(2)이 있으면 막힘
            cnt++;
            nx += dx[dir];
            ny += dy[dir];
        }
        return cnt; // 바깥으로 나가면 가장자리까지 연결 완료
	}
	
	static void setWire(int x, int y, int dir, int val, int need) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		for(int k=0; k<need; k++){
	        map[nx][ny] = val;
	        nx += dx[dir];
	        ny += dy[dir];
	    }
	}
}
