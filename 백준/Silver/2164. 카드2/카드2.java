import java.io.*;
import java.util.*;
  
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=1; i<=N; i++) q.add(i);

        while(q.size() != 1){
            q.poll();
            q.add(q.poll());
        }
        System.out.print(q.poll());
    }
}