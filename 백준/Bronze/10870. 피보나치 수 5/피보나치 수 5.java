import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        System.out.print(fib(N));
    }
    static int fib(int n){
        if(n<=1)
            return n;
        else
            return fib(n-1) + fib(n-2);
    }
}