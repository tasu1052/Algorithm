import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
	 
    	st = new StringTokenizer(br.readLine());
    	int V = Integer.parseInt(st.nextToken());
    	int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        int[] dist = new int[V+1];
        boolean[] visited = new boolean[V+1];
        ArrayList<Node> list[] = new ArrayList[V+1];
        for(int i=0; i<=V; i++) list[i] = new ArrayList<Node>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(K, 0));
        dist[K] = 0;

        while(!q.isEmpty()){
            Node now = q.poll();
            int now_to = now.to;
            
            if(visited[now_to]) continue;
            visited[now_to] = true;

            for(int i=0; i<list[now_to].size(); i++){
                Node tmp = list[now_to].get(i);
                int next_to = tmp.to;
                int next_weight = tmp.weight;

                if(dist[next_to] > dist[now_to] + next_weight){
                    dist[next_to] = next_weight + dist[now_to];
                    q.add(new Node(next_to, dist[next_to]));
                }
            }  
        }

        for(int i=1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append('\n');
            else sb.append(dist[i]).append('\n');

        }
        System.out.print(sb);
    }
}

class Node implements Comparable<Node>{
    int to;
    int weight;

    Node(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

    public int compareTo(Node e){
        if(this.weight > e.weight) return 1;
        else return -1;
    }
}