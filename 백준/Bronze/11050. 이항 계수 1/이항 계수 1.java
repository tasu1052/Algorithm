import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int mod=1;
        int den=1;
        int n = N+1;
        int k = K+1;
        for(int i=0; i<K; i++){
            n--;
            mod *= n;
            k--;
            den *= k;
        }
        int sum = mod/den;
        System.out.print(sum);
    }
}