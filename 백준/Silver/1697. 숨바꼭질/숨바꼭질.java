import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        boolean[] visited = new boolean[100001];

        dist[N] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == M){
                System.out.print(dist[now]);
                return;
            }

            int[] nextList = {now - 1, now + 1, now * 2};

            for(int next : nextList){
                if(next < 0 || next > 100000) continue;

                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
        
    }
}