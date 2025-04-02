import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
       
        boolean[] Prime = new boolean[N+1];
        Prime[0] = Prime[1] = true;
        for(int i=2; i<=Math.sqrt(N); i++){
            if(!Prime[i]){
                for(int j=i*i; j<=N; j+=i)
                    Prime[j] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=M; i<=N; i++){
            if(!Prime[i])
                sb.append(i).append('\n');
        }
        System.out.print(sb);
    }
}