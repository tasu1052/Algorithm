import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int N, M;
    static int[] order;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        order = new int[N+1];
        for(int i=0; i<=N; i++) A[i] = new ArrayList<Integer>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        
        for(int i=1; i<=N; i++) Collections.sort(A[i]);
        
        bfs(R);

        for(int i=1; i<=N; i++) sb.append(order[i]).append('\n');
        System.out.print(sb);
    }
    static void bfs(int r){
        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        visited[r] = true;

        int index = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            order[now] = index++;
            for(int i : A[now]){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}