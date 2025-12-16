import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> plusq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num >= 1) plusq.add(num);
            else minusq.add(num);
        }

        int sum = 0;
        
        while(plusq.size() > 1){
            int a = plusq.poll();
            int b = plusq.poll();

            if(a == 1 || b == 1){
                sum += a + b;
            }
            else sum += a * b;
        }
        if(!plusq.isEmpty()) sum += plusq.poll();

        while(minusq.size() > 1){
            int a = minusq.poll();
            int b = minusq.poll();
            
            sum += a * b;
        }
        if(!minusq.isEmpty()) sum += minusq.poll();
        
        System.out.print(sum);
    }
}