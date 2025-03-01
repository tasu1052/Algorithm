import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int index=2;
        int remainder=N;
        
        while(true){
            if(remainder%index==0){
                System.out.println(index);
                remainder=remainder/index;
            }    
            else{
                index++;
                if(index>N)
                    break;
            }
        }
    }
}