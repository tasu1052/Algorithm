import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int N = Integer.parseInt(br.readLine());
        
        int n=2;
        int i=1;
        int total=0;
        
        while(i<=N){
            n = (((n-1)*2)+1);
            total = (n*n);
            i++;
        }
        
        System.out.print(total);
        
    }
}