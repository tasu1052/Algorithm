import java.io.*;
import java.util.*;

public class Main {
    static int[] color;
    static ArrayList<Integer>[] A;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        

        int K = Integer.parseInt(br.readLine());

        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A = new ArrayList[V+1];
            color = new int[V+1];
            
            for(int i=0; i<=V; i++) A[i] = new ArrayList<Integer>();

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                A[s].add(e);
                A[e].add(s);
            }

            boolean check = true;
            for(int i=0; i<=V; i++){
                if(color[i] == 0){
                    if(!bfs(i)){
                        check = false;
                        break;
                    }
                }
            }

            if(check) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
    }
    static boolean bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : A[cur]){
                if(color[next] == 0){
                    color[next] = -color[cur];
                    q.add(next);
                }
                else if(color[next] == color[cur]){
                    return false;
                }
            }
        }
        return true;
    }
}