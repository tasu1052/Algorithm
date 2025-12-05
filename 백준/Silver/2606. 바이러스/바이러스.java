import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int N, M;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++) A[i] = new ArrayList<Integer>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        
        bfs(1);

        System.out.print(cnt);
    }
    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : A[now]){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
    }
}