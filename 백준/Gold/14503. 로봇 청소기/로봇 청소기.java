import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] cleaned;
    static int ans = 0;
    static int[] dx = {-1, 0, 1, 0}; //북 동 남 서
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sx =  Integer.parseInt(st.nextToken());
        int sy =  Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cleaned = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = sx, y = sy;

        while(true){

            if(!cleaned[x][y]) {
                cleaned[x][y] = true;
                ans++;
            }

            if(check(x,y)){ //주변 4칸 중 청소 안된 칸 있으면
                dir = (dir + 3) % 4; //반시계 90도 회전
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(map[nx][ny] == 0 && !cleaned[nx][ny]){ //바라보는 방향 기준 앞칸 청소x인경우
                    x = nx;
                    y = ny;
                }
            }
            else{
                int nx = x - dx[dir];
                int ny = y - dy[dir];

                if(map[nx][ny] == 1) break;

                x = nx;
                y = ny;
            }
        }

    System.out.println(ans);
    }
    static boolean check(int x, int y){ //check이 true면  청소 안된 빈칸 존재
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if (map[nx][ny] == 0 && !cleaned[nx][ny]) {
                return true;
            }
        }
        return false;
    }
}