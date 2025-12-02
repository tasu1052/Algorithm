import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int N;
    static int S;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        backtracking(0, 0);

        if(S == 0) cnt--;
        System.out.print(cnt);
    }
    static void backtracking(int sum, int idx){
        if(idx == N){
            if(sum == S) cnt++;
            return;
        }

        backtracking(sum + arr[idx], idx + 1);
        backtracking(sum, idx + 1);
    }
}