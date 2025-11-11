import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.second != b.second ? a.second - b.second : a.first - b.first
        );

        String[] tokens;
        for(int i=0; i<N; i++){
            tokens = br.readLine().split(" ");
            int f = Integer.parseInt(tokens[0]);
            int s = Integer.parseInt(tokens[1]);
            pq.add(new Pair(f, s));
        }

        int idx;
        int count =0;
        
        while(!pq.isEmpty()){
            idx = pq.poll().second;
            count++;
            while(!pq.isEmpty() && idx>pq.peek().first) pq.poll();
        }

        System.out.print(count);
    }
}

class Pair{
    int first, second;
    Pair(int f, int s){first = f; second = s;}
}