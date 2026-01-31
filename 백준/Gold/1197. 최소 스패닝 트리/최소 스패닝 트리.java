import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Edge> edges;
    static int[] parent;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        parent = new int[V+1];
        for(int i=1; i<=V; i++) parent[i] = i;
        
        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(s, e, w));
        }

        Collections.sort(edges);

        int edgeCnt = 0;
        int idx = 0;
        int ans = 0;
        while(edgeCnt != V-1){
            Edge tmp = edges.get(idx++);
            if(find(tmp.start) != find(tmp.end)){
                union(tmp.start, tmp.end);
                edgeCnt++;
                ans += tmp.weight;
            }
        }

        System.out.print(ans);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;
        }
    }
    static int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
}
class Edge implements Comparable<Edge>{
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e){
        return Integer.compare(this.weight, e.weight);
    }
}
