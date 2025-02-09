import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        String[] str = S.split("");
        int a = S.length();
        
        if(S.contains("=") || S.contains("-")){
            for(int i=0; i<str.length; i++){
                if(str[i].equals("=") || str[i].equals("-")){
                    if(i>=2){
                        if(str[i-2].equals("d") && str[i-1].equals("z") && str[i].equals("="))
                            a = a-1;
                        
                    }
                    a = a-1;
                }
            }
        }
          
        if(S.contains("lj") || S.contains("nj")){
            for(int i=1; i<str.length; i++){
                if((str[i-1].equals("l") && str[i].equals("j")) ||
                   (str[i-1].equals("n") && str[i].equals("j")))
                    a=a-1;
            }    
        }
        
        System.out.print(a);
        
    }
}