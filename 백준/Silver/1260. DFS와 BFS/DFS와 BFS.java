import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<N+1; i++) A[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for(int i=1; i<=N; i++) Collections.sort(A[i]);

        dfs(v);
        sb.append('\n');
        for(int i=1; i<=N; i++) visited[i] = false;
        bfs(v);

        System.out.print(sb);
    }
    static void dfs(int v){
        visited[v] = true;
        sb.append(v).append(" ");
        for(int i: A[v]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);

        while(!q.isEmpty()){
            int nowNode = q.poll();
            sb.append(nowNode).append(" ");
            for(int i : A[nowNode]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);    
                }
            }
        }
    }
}