import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for(int i=0; i<N; i++)
            arr[i] = Long.parseLong(br.readLine());
        
        long[] diff = new long[N-1];
        for(int i=0; i<N-1; i++)
            diff[i] = arr[i+1] - arr[i];
        

        long min=diff[0];
        for(int i=1; i<N-1; i++)
            min = gcd(min, diff[i]);
        
        long count = 0;
        for (int i = 0; i < N - 1; i++)
            count += (diff[i] / min) - 1; 
        
        System.out.print(count);
    }
    
    public static long gcd(long a, long b){
        while(b!=0){
            long tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }
}