import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        int num = A*D + B*C;
        int den = B * D;
        
        int gcd = gcd(num, den);
        
        System.out.print((num/gcd) + " " + (den/gcd));
    }
    public static int gcd(int a, int b){
        while(b!=0){
            int tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }
}