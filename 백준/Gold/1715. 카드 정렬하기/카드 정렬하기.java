import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            q.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        
        while(q.size() > 1){
            int a = q.poll();
            int b = q.poll();
            int tmp = a + b;
            sum += tmp;
            q.add(tmp);
        }
        System.out.print(sum);
    }
}