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

        int[] dist = new int[max + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[V] = 0;
        q.offer(new Node(V, 0));

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.value > dist[now.to]) continue;

            if(now.to * 2 <= max){
                if(dist[now.to * 2] > dist[now.to]){
                    dist[now.to * 2] = dist[now.to];
                    q.offer(new Node(now.to * 2, dist[now.to * 2]));
                }
            }
            if(now.to + 1 <= max){
                if(dist[now.to + 1] > dist[now.to] + 1){
                    dist[now.to + 1] = dist[now.to] + 1;
                    q.offer(new Node(now.to + 1, dist[now.to + 1]));
                }
            }
            if(now.to - 1 >= 0){
                if(dist[now.to - 1] > dist[now.to] + 1){
                    dist[now.to - 1] = dist[now.to] + 1;
                    q.offer(new Node(now.to - 1, dist[now.to - 1]));
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