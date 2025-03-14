import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        if(N==0){
            System.out.print(1);
            return;
        }
        long sum=1;
        for(int i=1; i<=N; i++){
            sum=i*sum;
        }
        
        System.out.print(sum);
    }
}