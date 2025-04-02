import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            long n = Long.parseLong(br.readLine());
            sb.append(findNextPrime(n)).append('\n');
        }
        System.out.print(sb);
    }

    public static long findNextPrime(long n){
        if(n <= 2) 
            return 2;

        long candidate = n;
        while(true){
            if (isPrime(candidate)) 
                return candidate;
            candidate++;
        }
    }

    public static boolean isPrime(long num){
        if (num < 2) 
            return false;
        if (num == 2) 
            return true;
        if (num % 2 == 0) 
            return false; 

        for(long i=3; i<=Math.sqrt(num); i+=2){
            if(num % i == 0) 
                return false;
        }
        return true;
    }
}