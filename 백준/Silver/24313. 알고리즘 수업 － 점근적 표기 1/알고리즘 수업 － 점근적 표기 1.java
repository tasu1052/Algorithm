import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
       
        if(a1>c){
            System.out.print(0);
            return;
        }
        
        if(a1==c){
            if(a0<=0)
                System.out.print(1);
            else
                System.out.print(0);
        }
        
        if(a1<c){
            if((a1*n0+a0)<=(c*n0))
                System.out.print(1);
            else
                System.out.print(0);
        }
    }
}