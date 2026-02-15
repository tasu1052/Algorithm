import java.io.*;
import java.util.*;

class Solution {
    static int[] cx;
    static int[] cy;
    static int comX, comY, homeX, homeY;
    static int ans;
    static boolean[] used;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine()); //고객 수

            st = new StringTokenizer(br.readLine());

            //회사 좌표
            comX = Integer.parseInt(st.nextToken());
            comY = Integer.parseInt(st.nextToken());

            //집 좌표
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());

            cx = new int[N];
            cy = new int[N];
            used = new boolean[N];
            ans = Integer.MAX_VALUE;
            
            for(int i=0; i<N; i++){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                cx[i] = x;
                cy[i] = y;
            }

            dfs(0, comX, comY, 0);
            
            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }

        System.out.print(sb);
    }
    static void dfs(int depth, int lastX, int lastY, int sum){
        if(sum >= ans) return;
        if(depth == N){
            ans = Math.min(ans, sum + dist(lastX, lastY, homeX, homeY));
            return;
        }

        for(int i=0; i<N; i++){
            if(!used[i]){
                used[i] = true;
                dfs(depth + 1, cx[i], cy[i], sum + dist(lastX, lastY, cx[i], cy[i]));
                used[i] = false;
            }
        }
    }
    static int dist(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}