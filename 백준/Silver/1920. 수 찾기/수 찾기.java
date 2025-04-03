import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hs = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            hs.add(Integer.parseInt(st.nextToken()));
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            if(hs.contains(Integer.parseInt(st.nextToken())))
                sb.append(1).append('\n');
            else
                sb.append(0).append('\n');
        }
        System.out.print(sb);
    }
}