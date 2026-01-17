import java.io.*;
import java.util.*;

public class Main{
    static final int max = 100000;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
    	int V = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());

        ArrayList<Node> list[] = new ArrayList[max + 1];
        for(int i=0; i<=max; i++) list[i] = new ArrayList<>();
        int[] dist = new int[max + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<=max; i++){
            if(i*2 <= max) list[i].add(new Node(i*2, 0));
            if(i+1 <= max) list[i].add(new Node(i+1, 1));
            if(i-1 >= 0) list[i].add(new Node(i-1, 1));
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[V] = 0;
        q.offer(new Node(V, 0));

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
        System.out.print(dist[K]);
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