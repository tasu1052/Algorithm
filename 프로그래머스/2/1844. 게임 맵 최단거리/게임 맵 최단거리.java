import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dist;
    static int n, m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        dist = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], -1);
        }
        
        bfs(0, 0, maps);
        
        return dist[n-1][m-1];
    }
    static void bfs(int i, int j, int[][] maps){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        dist[i][j] = 1;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny] != -1) continue;
                
                if(maps[nx][ny] == 1){
                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}