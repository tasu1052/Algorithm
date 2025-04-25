import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int sum = 0;
        Set<String> hs = new HashSet<>();
        for(int i=0; i<N; i++){
            String S = br.readLine();
            if(S.equals("ENTER")){
                sum += hs.size();
                hs.clear();
            }
            else
                hs.add(S);
        }
        sum += hs.size();
        System.out.print(sum);
    }
}