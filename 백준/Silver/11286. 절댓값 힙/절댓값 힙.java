import java.io.*;
import java.util.*;
  
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a) == Math.abs(b)) return Long.compare(a, b);
            return Long.compare(Math.abs(a), Math.abs(b));
        });

        for(int i=0; i<N; i++){
            long num = Long.parseLong(br.readLine());
            if(num == 0){
                if(pq.isEmpty()) sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            }
            else{
                pq.add(num);
            }
        }
        System.out.print(sb);
    }
}