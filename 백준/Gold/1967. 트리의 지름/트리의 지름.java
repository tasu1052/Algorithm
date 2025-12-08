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

        int n = Integer.parseInt(br.readLine());

        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        distance = new int[n+1];

        for(int i=0; i<n+1; i++) A[i] = new ArrayList<Edge>();
        
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[s].add(new Edge(e, v));
            A[e].add(new Edge(s, v));
        }

        bfs(1);

        int max = 1;
        for(int i=2; i<=n; i++){
            if(distance[max] < distance[i]) max = i;
        }

        visited = new boolean[n+1];
        distance = new int[n+1];

        bfs(max);

        int ans = 0;
        for(int i=0; i<n+1; i++){
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
                int to = i.to;
                int value = i.value;

                if(!visited[to]){
                    visited[to] = true;
                    q.add(to);
                    distance[to] = distance[now] + value;
                }
            }
        }
    }
}

class Edge{
    int to;
    int value;
    
    Edge(int to, int value){
        this.to = to;
        this.value = value;
    }
}