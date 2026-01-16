import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
    	int E = Integer.parseInt(st.nextToken());
    	int V = Integer.parseInt(st.nextToken());

        ArrayList<Node> list[] = new ArrayList[V+1];
        for(int i=0; i<=V; i++) list[i] = new ArrayList<>();
        boolean[] visited = new boolean[V+1];
        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(v > V) continue;
            list[u].add(new Node(v, w));
        }

        for(int i=0; i<V; i++) list[i].add(new Node(i+1, 1));
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[0] = 0;
        q.offer(new Node(0, 0));

        while(!q.isEmpty()){
            Node now = q.poll();

            if(visited[now.to]) continue;
            visited[now.to] = true;

            for(Node next : list[now.to]){
                if(dist[next.to] > dist[now.to] + next.value){
                    dist[next.to] = dist[now.to] + next.value;
                    q.offer(new Node(next.to, dist[next.to]));
                }
            }
        }        
        System.out.print(dist[V]);
    }
}
class Node implements Comparable<Node>{
    int to;
    int value;

    Node(int to, int value){
        this.to = to;
        this.value = value;
    }
    @Override
    public int compareTo(Node n){
        return this.value - n.value;
    }
}