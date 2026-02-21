import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] cards;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) cards[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0, 0);

        System.out.print(ans);
    }
    static void dfs(int start, int cnt, int sum){
        if(sum > M) return;
        
        if(cnt == 3){
            ans = Math.max(ans, sum);
            return;
        }
        
        if(N - start < 3 - cnt) return;


        for(int i=start; i<N; i++){
            dfs(i + 1, cnt + 1, sum + cards[i]);
        }
    }
}