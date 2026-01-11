import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer> A[];
    static int[] dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i=0; i<=N; i++) A[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            A[s].add(e);
        }

        bfs(X);

        for(int i=1; i<=N; i++){
            if(dist[i] == K) sb.append(i).append('\n');
        }
        if(sb.length() == 0) sb.append(-1).append('\n');
        
        System.out.print(sb);
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, -1);
        dist[start] = 0; 
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : A[now]){
                if(dist[next] == -1){
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }

    }
}