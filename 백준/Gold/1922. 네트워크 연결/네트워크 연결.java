import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static ArrayList<Edge> edges;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        parent = new int[V+1];
        for(int i=1; i<=V; i++) parent[i] = i;
        edges = new ArrayList<>();

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(s, e, w));
        }

        Collections.sort(edges);

        int edgeCnt = 0;
        int cost = 0;
        for(Edge tmp : edges){
            if(find(tmp.start) != find(tmp.end)){
                union(tmp.start, tmp.end);
                cost += tmp.weight;
                edgeCnt++;
            }
            if(edgeCnt == V-1) break;
        }

        System.out.println(cost);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
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

    public Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o){
        return Integer.compare(this.weight, o.weight);
    }
}