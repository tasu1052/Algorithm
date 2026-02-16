import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static int[][] arr;
    static int A;
    static int B;
    static int ans;
    static boolean[] pick;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            pick = new boolean[N];
            
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            } //배열 초기화

            ans = Integer.MAX_VALUE;
            pick[0] = true;
            dfs(1, 1);

            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int idx, int chosen){
        if(chosen == N/2){
            cal();
            return;
        }

        if(idx == N) return;

        pick[idx] = true;
        dfs(idx + 1, chosen + 1);

        pick[idx] = false;
        dfs(idx + 1, chosen);
    }
    static void cal(){
        int aSum = 0, bSum = 0;

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                int s = arr[i][j] + arr[j][i];
                if(pick[i] && pick[j]) aSum += s;
                else if(!pick[i] && !pick[j]) bSum += s;
            }
        }

        ans = Math.min(ans, Math.abs(aSum - bSum));
    }
}
