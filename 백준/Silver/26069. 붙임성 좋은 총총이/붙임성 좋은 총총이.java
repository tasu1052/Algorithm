import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set <String> hs = new HashSet<>();
        hs.add("ChongChong");
        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if(hs.contains(A) || hs.contains(B)){
                hs.add(A);
                hs.add(B);
            }
        }
        System.out.print(hs.size());
    }
}