import java.util.*;
import java.io.*;

class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] order;
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        order = new int[N+1];

        for(int i=1; i<=N; i++) A[i] = new ArrayList<Integer>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(A[i]);
        }

        dfs(R);

        for(int i=1; i<=N; i++){
            sb.append(order[i]).append('\n');
        }
        
        System.out.print(sb);
    }
    static void dfs(int v){
        visited[v] = true;
        order[v] = cnt++;
        for(int i : A[v]){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}