import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min = Math.min(a,b);
        int max=0;
        
        for(int i=2; i<=min; i++){
            if(a%i==0 && b%i==0){
                max=Math.max(max, i);
            }
        }
        if(max==0)
            max=1;
        
        System.out.println(max);
        System.out.print((a/max)*(b/max)*max);
        
    }
}