import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        System.out.print(fact(N));
    }
    static long fact(int n){
        if(n==0)
            return 1;
        else
            return n * fact(n-1);
    }
}