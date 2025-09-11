import java.io.*;
import java.util.*;

public class Main{
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arr = new int[M];
        
        backtracking(0);

        System.out.print(sb);
        
    }
    
    static void backtracking(int depth){
        if(depth == M){
            for(int i=0; i<arr.length - 1; i++){
                if(arr[i]>arr[i+1])
                    return;
            }
            for(int i=0; i<arr.length; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
                
            }
        }
    }
}