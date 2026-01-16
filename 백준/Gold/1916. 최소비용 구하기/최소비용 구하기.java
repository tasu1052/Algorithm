import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
	 
    	int V = Integer.parseInt(br.readLine());
    	int E = Integer.parseInt(br.readLine());
        
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

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(visited[now.to]) continue;
            visited[now.to] = true;

            for(Node next : list[now.to]){
                if(dist[next.to] > dist[now.to] + next.cost){
                    dist[next.to] = dist[now.to] + next.cost;
                    q.offer(new Node(next.to, dist[next.to]));
                }
            }  
        }
        sb.append(dist[end]);
        System.out.print(sb);
    }
}

class Node implements Comparable<Node>{
    int to;
    int cost;

    Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }

    public int compareTo(Node e){
        if(this.cost > e.cost) return 1;
        else return -1;
    }
}