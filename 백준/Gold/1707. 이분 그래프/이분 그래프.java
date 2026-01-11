import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer> A[];
    static int[] color;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A = new ArrayList[v+1];
            for(int j=0; j<=v; j++) A[j] = new ArrayList<>();
            color = new int[v+1];

            for(int j=0; j<e; j++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());

                A[S].add(E);
                A[E].add(S);
            }

            boolean check = true;
            for(int j=0; j<=v; j++){
                if(color[j] == 0){
                    if(!bfs(j)){
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
    static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        color[start] = -1;
        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : A[cur]){
                if(color[next] == 0){
                    color[next] = color[cur] * -1;
                    q.add(next);
                }
                else if(color[next] == color[cur]) return false;
            }
        }
        return true;
    }
}