import java.io.*;
import java.util.*;

public class Solution {
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());

            map = new int[N][N]; // 맵 배열 생성 및 초기화
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int ans = -1;

            visited = new boolean[N][N][3];
            ArrayDeque<int[]> q = new ArrayDeque<>(); //bfs 시작, 시작지점 넣기
            
            visited[startX][startY][0] = true;
            q.add(new int[]{startX, startY, 0});

            while(!q.isEmpty()){
                int[] cur = q.poll(); //하나 빼서 거기 기준 bfs하는 로직
                int cx = cur[0], cy = cur[1], t = cur[2];

                if(cx == endX && cy == endY){ //하나 뽑은게 도착지점이면 출력
                    ans = t;
                    break;
                }

                int nt = t + 1;

                if(!visited[cx][cy][nt%3]){
                    visited[cx][cy][nt%3] = true;
                    q.add(new int[]{cx, cy, nt});
                }

                for(int k=0; k<4; k++){ //사방탐색
                    int x = cur[0] + dx[k];
                    int y = cur[1] + dy[k];

                    if(x < 0 || x >= N || y < 0 || y >= N) continue; //경계값 처리
                    if(map[x][y] == 1) continue;

                    if(map[x][y] == 2 && (nt % 3 != 0)) continue;

                    if(!visited[x][y][nt % 3]){ //아직 방문하지 않은 갈 수 있는 길 방분
                        visited[x][y][nt % 3] = true;
                        q.add(new int[]{x, y, nt});
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append('\n');
            
        }
        
        System.out.print(sb);
        
    }
}
