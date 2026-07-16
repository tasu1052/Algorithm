import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dist;
    static boolean[][] visited;
    static int n, m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        dist = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<dist.length; i++){
            Arrays.fill(dist[i], -1);
        }
        
        bfs(0, 0, maps);
        
        return dist[n-1][m-1];
    }
    static void bfs(int x, int y, int[][] maps){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[x][y] = 1;
        visited[x][y] = true;
        q.add(new int[]{x, y});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int k=0; k<4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;

                if(maps[nx][ny] != 0){
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[now[0]][now[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}