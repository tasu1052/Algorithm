import java.util.*;
import java.io.*;

class Main {
    static int[] S;
    static int[] arr;
    static int N;
    static int M;
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        S = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);

        backtracking(0);
        
        System.out.print(sb);
    }
    static void backtracking(int depth){
        if(depth == M){
            for(int i : S){
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                S[depth] = arr[i];
                if(depth > 0 && S[depth-1] > S[depth]){
                    visited[i] = false;
                    continue;
                }
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}