import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap <Integer, Integer> hm = new HashMap<>();
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=1; i<=N; i++){
            int count =1;
            int num = Integer.parseInt(st.nextToken());
            
            if(hm.containsKey(num)){
                count = hm.get(num);
                count++;
                hm.put(num, count);
                continue;
            }
            hm.put(num, count);
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(hm.containsKey(num))
                sb.append(hm.get(num)).append(' ');
            else
                sb.append(0).append(' ');
        }
        System.out.print(sb);
        
    }
}