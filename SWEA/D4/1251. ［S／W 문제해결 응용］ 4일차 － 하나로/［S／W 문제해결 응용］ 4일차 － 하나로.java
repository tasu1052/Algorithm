import java.io.*;
import java.util.*;

public class Solution {
    static int[] parent;
    static double E;
    static long[] xs, ys;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());

            xs = new long[N];
            ys = new long[N];

            // X 좌표 N개 (한 줄)
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) xs[i] = Long.parseLong(st.nextToken());

            // Y 좌표 N개 (한 줄)
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) ys[i] = Long.parseLong(st.nextToken());

            E = Double.parseDouble(br.readLine().trim());

            ArrayList<Edge> edges = new ArrayList<>();

            for(int i=0; i<N-1; i++){
                for(int j=i+1; j<N; j++){
                    long dx = xs[i] - xs[j];
                    long dy = ys[i] - ys[j];
                    double w = E * (dx*dx + dy*dy);
                    edges.add(new Edge(i, j, w));
                }
            }

            Collections.sort(edges);

            parent = new int[N];
            for(int i=0; i<N; i++) parent[i] = i;

            double ans = 0.0;
            int edgeCnt = 0;
            int idx = 0;

            while(edgeCnt < N-1){
                Edge e = edges.get(idx++);
                if(find(e.u) != find(e.v)){
                    union(e.u, e.v);
                    ans += e.w;
                    edgeCnt++;
                }
            }

            sb.append('#').append(tc).append(' ')
                    .append(Math.round(ans)).append('\n');
        }

        System.out.print(sb);
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

    static class Edge implements Comparable<Edge>{
        int u, v;
        double w;
        Edge(int u, int v, double w){
            this.u = u; this.v = v; this.w = w;
        }
        @Override
        public int compareTo(Edge o){
            return Double.compare(this.w, o.w);
        }
    }
}