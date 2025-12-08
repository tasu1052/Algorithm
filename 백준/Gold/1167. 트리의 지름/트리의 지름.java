import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(br.readLine());

        A = new ArrayList[V+1];
        visited = new boolean[V+1];
        distance = new int[V+1];

        for(int i=0; i<=V; i++) A[i] = new ArrayList<Edge>();

        for(int i=0; i<V; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                int w = Integer.parseInt(st.nextToken());

                A[s].add(new Edge(e, w));
            }
        }
        
        int max = 1;
        bfs(1);
        for(int i=2; i<=V; i++){
            if(distance[max] < distance[i]) max = i;
        }

        visited = new boolean[V+1];
        distance = new int[V+1];
        
        bfs(max);
        
        int ans = 0;
        for (int i = 1; i <= V; i++) {
            ans = Math.max(ans, distance[i]);
        }
        System.out.print(ans);
    }
    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);

        while(!q.isEmpty()){
            int now = q.poll();
            for(Edge i : A[now]){
                int e = i.to;
                int w = i.weight;
                if(!visited[e]){
                    visited[e] = true;
                    q.add(e);
                    distance[e] = distance[now] + w;
                }
            }
        }
    }
}
class Edge{
    int to;
    int weight;
    public Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
}
