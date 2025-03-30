import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        
        long d = gcd(A, B);
        
        System.out.print(A*B/d);
    }
    public static long gcd(long a, long b){
        if(b==0) 
            return a;
        return gcd(b, a%b);
    }
}