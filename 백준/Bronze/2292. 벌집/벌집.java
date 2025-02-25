import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int N = Integer.parseInt(br.readLine());
        
        int i=1;
        int range=1;
        int add=6;
        
        while(range < N){
            range +=add;
            add +=6;
            i++;
        }
        System.out.print(i);
    }
}