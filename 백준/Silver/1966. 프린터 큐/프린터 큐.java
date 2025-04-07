import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             Deque <int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                q.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            
            int index = 0;
            while (!q.isEmpty()){
                int[] front = q.pollFirst();
                boolean bigger = false;

                for(int[] pos : q){
                    if(pos[1] > front[1]){
                        bigger = true;
                        break;
                    }
                }
                if(bigger) q.offerLast(front);
                else{
                    index++;
                    if(front[0]==M){
                        sb.append(index).append('\n');
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}