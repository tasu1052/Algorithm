import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList<>();
        long[] dist = new long[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges.add(new Edge(A, B, C));
        }

        dist[1] = 0;

        for(int i=1; i<=N-1; i++){
            for(Edge e : edges){
                if(dist[e.start] != Integer.MAX_VALUE &&
                   dist[e.end] > dist[e.start] + e.weight){
                    dist[e.end] = dist[e.start] + e.weight;
                }
            }
        }

        for(Edge e : edges){
            if(dist[e.start] != Integer.MAX_VALUE &&
                dist[e.end] > dist[e.start] + e.weight){
                System.out.print(-1);
                return;
            }
        }
        

        for(int i=2; i<=N; i++){
            if(dist[i] != Integer.MAX_VALUE) sb.append(dist[i]).append('\n');
            else sb.append(-1).append('\n');
        }

        System.out.print(sb);
    }
}
class Edge{
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}