import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] type = new int[N];

        for (int i = 0; i < N; i++)
            type[i] = Integer.parseInt(st.nextToken());
        

        st = new StringTokenizer(br.readLine(), " ");
        int[] value = new int[N];

        for (int i = 0; i < N; i++)
            value[i] = Integer.parseInt(st.nextToken());
        
        int M = Integer.parseInt(br.readLine());
        int[] input = new int[M];
        st= new StringTokenizer(br.readLine(), " ");
        
        for(int i=0; i<M; i++)
            input[i] = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++){
            if(type[i]==0){
                q.offerFirst(value[i]);
            }
        }
        
        for(int i=0; i<M; i++){
            q.offerLast(input[i]);
            sb.append(q.pollFirst()).append(" ");
        }
        
        System.out.print(sb);
        
    }
}