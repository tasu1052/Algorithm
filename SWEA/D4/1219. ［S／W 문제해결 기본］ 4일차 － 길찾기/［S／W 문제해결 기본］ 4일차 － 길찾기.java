import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 10;//Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int E = Integer.parseInt(st.nextToken());

            A = new ArrayList[100];
            for(int i=0; i<100; i++) A[i] = new ArrayList<>();
            visited = new boolean[100];

            st = new StringTokenizer(br.readLine());
            
            for(int i=0; i<E; i++){
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                A[s].add(e);
            }

            bfs(0);

            if(visited[99]) sb.append("#").append(tc).append(" ").append(1).append('\n');
            else sb.append("#").append(tc).append(" ").append(0).append('\n');
        }

        System.out.print(sb);
    }
    static void bfs(int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : A[now]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}