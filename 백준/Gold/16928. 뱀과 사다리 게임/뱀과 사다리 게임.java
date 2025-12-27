import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A = new ArrayList[101];
    static boolean[] visited = new boolean[101];
    static int[] dist = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<101; i++){
            A[i] = new ArrayList<Integer>();
        }
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;
        visited[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int dice=1; dice<=6; dice++){
                int next = cur + dice;
                
                if(next > 100) continue;

                if(!A[next].isEmpty()){
                    next = A[next].get(0);
                }

                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
        System.out.print(dist[100]);
    }
}