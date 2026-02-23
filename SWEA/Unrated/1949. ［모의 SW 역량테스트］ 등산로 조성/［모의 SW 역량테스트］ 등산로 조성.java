import java.io.*;
import java.util.*;

public class Solution {
    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int ans;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];

            int maxH = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxH = Math.max(maxH, map[i][j]);
                }
            }

            ans = 1;

            // 가장 높은 봉우리들에서 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxH) {
                        visited[i][j] = true;
                        dfs(i, j, map[i][j], false, 1);
                        visited[i][j] = false;
                    }
                }
            }

            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int x, int y, int curH, boolean cutUsed, int len) {
    	ans = Math.max(ans, len);
    	
    	for(int d=0; d<4; d++) {
    		int nx = x + dx[d];
    		int ny = y + dy[d];
    		
    		if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
    		if(visited[nx][ny]) continue;
    		
    		if(map[nx][ny] < curH) {
    			visited[nx][ny] = true;
    			dfs(nx, ny, map[nx][ny], cutUsed, len + 1);
    			visited[nx][ny] = false;
    		}
    		else if(!cutUsed) {
    			int need = map[nx][ny] - (curH - 1);
    			if(need >= 1 && need <= K) {
    				visited[nx][ny] = true;
    				dfs(nx, ny, curH - 1, true, len + 1);
    				visited[nx][ny] = false;
    			}
    		}
    	}

    }
}