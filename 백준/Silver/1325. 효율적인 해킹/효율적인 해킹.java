import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer> A[];
    static int[] cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        cnt = new int[N+1];

        Arrays.fill(cnt, 1);

        for(int i=0; i<=N; i++) A[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            A[e].add(s);
        }

        for(int i=1; i<=N; i++){
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            if(cnt[i] > max) max = cnt[i];
        }

        for(int i=1; i<=N; i++){
            if(max == cnt[i]) sb.append(i).append(" ");
        }
        
        System.out.print(sb);
    }
    static void bfs(int start) {
        boolean[] visited = new boolean[A.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : A[now]){
                if(!visited[next]){
                    visited[next] = true;
                    cnt[start]++;
                    q.add(next);
                }
            }
        }

    }
}