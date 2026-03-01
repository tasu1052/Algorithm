import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] dx = {-1, 1, 1, -1};
    static int[] dy = {1, 1, -1, -1};
    static int[][] map;
    static boolean[] picked;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            picked = new boolean[N];
            ans = Integer.MAX_VALUE;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0);
            
            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }

        System.out.print(sb);
    }
    static void dfs(int start, int cnt){
        if(ans == 0) return;
        
        if(cnt == N/2){
            int firstFood = 0, secondFood = 0;

            for(int i=0; i<N-1; i++){
                for(int j=i+1; j<N; j++){
                    if(picked[i] && picked[j]){
                        firstFood += map[i][j] + map[j][i];
                    }
                    else if(!picked[i] && !picked[j]){
                        secondFood += map[i][j] + map[j][i];
                    }
                }
            }

            ans = Math.min(ans, Math.abs(firstFood - secondFood));
            return;
        }

        for(int i=start; i<N; i++){
            picked[i] = true;
            dfs(i + 1, cnt + 1);
            picked[i] = false;
        }
    }
}