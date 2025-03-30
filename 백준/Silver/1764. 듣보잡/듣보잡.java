import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet <String> see = new TreeSet<>();
        TreeSet <String> hear = new TreeSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++)
            see.add(br.readLine());
        
        for(int i=0; i<M; i++)
            hear.add(br.readLine());
        
        int count=0;
        StringBuilder sb = new StringBuilder();
        for(String S : see){
            if(see.contains(S) && hear.contains(S)){
                count++;
                sb.append(S).append('\n');
            }
        }
        System.out.println(count);
        System.out.print(sb);
    }
}