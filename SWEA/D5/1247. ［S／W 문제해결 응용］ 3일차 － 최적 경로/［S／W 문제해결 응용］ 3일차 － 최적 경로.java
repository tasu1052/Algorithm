import java.io.*;
import java.util.*;

public class Solution {
    static int N, comX, comY, homeX, homeY;
    static Customer[] arr;
    static boolean[] v;
    static int ans;
    // static int[] dx = {0, 1, 0, -1};
    // static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());

            arr = new Customer[N];
            v = new boolean[N];
            ans = Integer.MAX_VALUE;
            
            st = new StringTokenizer(br.readLine());

            comX = Integer.parseInt(st.nextToken());
            comY = Integer.parseInt(st.nextToken());

            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());

            for(int i=0; i<N; i++){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[i] = new Customer(x, y);
            }

            dfs(0, comX, comY, comX, comY, 0);

            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }

        System.out.print(sb);
    }
    static void dfs(int idx, int x, int y, int lastX, int lastY, int dist){
        if(idx == N){
            ans = Math.min(ans, dist + cal(homeX, homeY, x, y));
            return;
        }

        if(dist >= ans) return;

        for(int i=0; i<N; i++){
            if(v[i]) continue;
            v[i] = true;
            dfs(idx + 1, arr[i].x, arr[i].y, x, y, 
                dist + cal(arr[i].x, arr[i].y, x, y));
            v[i] = false;
        }
    }
    static int cal(int x, int y, int lastX, int lastY){
        return Math.abs(x - lastX) + Math.abs(y - lastY);
    }
}
class Customer{
    int x, y;

    Customer(int x, int y){
        this.x = x;
        this.y = y;
    }
}