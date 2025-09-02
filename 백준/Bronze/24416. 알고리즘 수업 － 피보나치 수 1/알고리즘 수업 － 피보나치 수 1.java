import java.io.*;
import java.util.*;

public class Main{
    static int rcount = 0;
    static int dcount = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);

        System.out.print(rcount + " " + dcount);
    }

    static int fib(int n){
        if(n==1 || n==2){
            rcount++;
            return 1;
    }
        else{
            return fib(n-1) + fib(n-2);
        }
    }
    
    static int fibonacci(int n){
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2; i<n; i++){
            arr[i] = arr[i-1] + arr[i-2];
            dcount++;
        }
        return arr[n];
    }
}