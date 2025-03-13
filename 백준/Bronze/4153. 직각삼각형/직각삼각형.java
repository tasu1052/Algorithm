import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int max = Math.max(Math.max(a,b),c);
            
            if(a==0 && b==0 && c==0)
                break;
            
            if(max==a){
                if((b*b)+(c*c)==max*max)
                    System.out.println("right");
                else
                    System.out.println("wrong");
            }
            else if(max==b){
                if((a*a)+(c*c)==max*max)
                    System.out.println("right");
                else
                    System.out.println("wrong");
            }
            else if(max==c){
                if((a*a)+(b*b)==max*max)
                    System.out.println("right");
                else
                    System.out.println("wrong");
            }
        }
    }
}
