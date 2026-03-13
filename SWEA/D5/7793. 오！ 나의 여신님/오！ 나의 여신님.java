import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static char[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] deTime;
	static int[][] escapeTime;
	static ArrayDeque<int[]> dq = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine()); //N, M 받기
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M]; //맵 초기화
            deTime = new int[N][M]; //악마가 움직이는 시간 저장하는 배열
            escapeTime = new int[N][M]; //수연이가 탈출에 소요되는 시간 저장하는 배열
            
            for(int i=0; i<N; i++) Arrays.fill(deTime[i], -1);
            for(int i=0; i<N; i++) Arrays.fill(escapeTime[i], -1);
            
            int suX = -1, suY = -1; //수연이 시작위치
            int endX = -1, endY = -1; //여신 위치
            
            for(int i=0; i<N; i++) { //맵 받아주기
            	String line = br.readLine();
            	for(int j=0; j<M; j++) {
            		map[i][j] = line.charAt(j);
            		if(map[i][j] == 'S') { //수연이랑 악마 시작 위치 정보 저장해놓기
            			suX = i; suY = j;
            		}
            		else if(map[i][j] == '*') {
            			dq.add(new int[] {i, j});
            			deTime[i][j] = 0;
            		}
            		else if(map[i][j] == 'D') {
            			endX = i; endY = j;
            		}
            	}
            }
            
            devil();
            escape(suX, suY);

            sb.append("#").append(tc).append(" ");
            if(escapeTime[endX][endY] == -1) sb.append("GAME OVER");
            else sb.append(escapeTime[endX][endY]);
            sb.append('\n');
        }

        System.out.print(sb);
    }
    static void devil() {
    	
    	while(!dq.isEmpty()) {
    		int[] now = dq.poll();
    		int x = now[0], y = now[1];
    		
    		for(int k=0; k<4; k++) {
    			int nx = x + dx[k], ny = y + dy[k];
    			
    			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
    			if(deTime[nx][ny] != -1) continue;
    			
    			if(map[nx][ny] == '.' || map[nx][ny] == 'S') {
    				deTime[nx][ny] = deTime[x][y] + 1;
    				dq.add(new int[] {nx, ny});
    			}
    		}
    	}
    }
    static void escape(int sx, int sy) {
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {sx, sy});
    	escapeTime[sx][sy] = 0;
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int x = now[0], y = now[1];
    		
    		for(int k=0; k<4; k++) {
    			int nx = x + dx[k], ny = y + dy[k];
    			
    			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
    			if(escapeTime[nx][ny] != -1) continue;
    			
    			int nextTime = escapeTime[x][y] + 1;
    			
    			if(map[nx][ny] == '.') {
    				if(deTime[nx][ny] == -1 || deTime[nx][ny] > nextTime) {
    					escapeTime[nx][ny] = nextTime;
    					q.add(new int[] {nx, ny});
    				}
    			}
    			else if(map[nx][ny] == 'D') {
    				escapeTime[nx][ny] = nextTime;
    			}
    		}
    	}
    }
}