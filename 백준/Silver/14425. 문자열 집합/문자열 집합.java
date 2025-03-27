import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hs = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++)
            hs.add(br.readLine());
        
        int count=0;
        for(int i=0; i<M; i++){
            if(hs.contains(br.readLine()))
                count++;
        }
        
        System.out.print(count);
    }
}