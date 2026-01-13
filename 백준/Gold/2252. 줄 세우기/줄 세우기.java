import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
	 
    	st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
	 
        ArrayList<Integer> A[] = new ArrayList[n+1];
        for(int i=0; i<=n; i++) A[i] = new ArrayList<>();
        int[] D = new int[n+1];

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            D[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(D[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur + " ");

            for(int next : A[cur]){
                D[next]--;
                if(D[next] == 0) q.offer(next);
            }
        }
        System.out.print(sb);
    }
}