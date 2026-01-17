import java.io.*;
import java.util.*;

public class Main{
    static int V;
    static ArrayList<Node> list[];
    static int[] dist;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
    	V = Integer.parseInt(st.nextToken());
    	int E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V+1];
        for(int i=0; i<=V; i++) list[i] = new ArrayList<>();
        long[] ans1 = new long[3];
        long[] ans2 = new long[3];
        
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(v > V) continue;
            list[u].add(new Node(v, w));
            list[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());
        
        ans1[0] = dkstra(1, target1);
        ans1[1] = dkstra(target1, target2);
        ans1[2] = dkstra(target2, V);

        ans2[0] = dkstra(1, target2);
        ans2[1] = dkstra(target2, target1);
        ans2[2] = dkstra(target1, V);

        long sum1 = 0;
        long sum2 = 0;

        for(long num : ans1) sum1 += num;
        for(long num : ans2) sum2 += num;

        long min = Math.min(sum1, sum2);

        if(min < Integer.MAX_VALUE) System.out.print(min);
        else System.out.print(-1);
        
    }
    static int dkstra(int start, int end){
        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[start] = 0;
        q.offer(new Node(start, 0));

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.value > dist[now.to]) continue;

            for(Node next : list[now.to]){
                if(dist[next.to] > dist[now.to] + next.value){
                    dist[next.to] = dist[now.to] + next.value;
                    q.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist[end];
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