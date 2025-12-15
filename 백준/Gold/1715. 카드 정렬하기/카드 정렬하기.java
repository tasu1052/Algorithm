import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            q.add(arr[i]);
        }

        int sum = 0;
        if(N == 1) sum = 0;
        else if(N == 2) sum = q.poll() + q.poll();
        else{
            while(!q.isEmpty()){
                int tmp = 0;
                int a = q.poll();
                int b = q.poll();
                tmp = a + b;
                sum += tmp;
                if(!q.isEmpty()) q.add(tmp);
            }
        }
        System.out.print(sum);
    }
}