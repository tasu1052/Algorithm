import java.io.*;
import java.util.*;
  
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        Deque<int[]> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());
            while(!dq.isEmpty() && dq.peekLast()[0] > now){
                dq.pollLast();
            }
            dq.addLast(new int[] {now, i});

            if(dq.peekFirst()[1] <= i-L){
                dq.pollFirst();
            }
            sb.append(dq.peekFirst()[0]).append(" ");
        }
        System.out.print(sb);
    }
}