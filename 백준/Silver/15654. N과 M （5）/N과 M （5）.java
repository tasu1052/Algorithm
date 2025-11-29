import java.util.*;
import java.io.*;

class Main {
    static int[] S;
    static int[] arr;
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        S = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);

        backtracking(N, M, 0);
        
        System.out.print(sb);
    }
    static void backtracking(int N, int M, int length){
        if(length == M){
            for(int i : S){
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                S[length] = arr[i];
                backtracking(N, M, length + 1);
                visited[i] = false;
            }
        }
    }
}