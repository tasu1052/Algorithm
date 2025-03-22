import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(Character.isUpperCase(c)){
                c = Character.toLowerCase(c);
                sb.append(c);
                
            }
            else{
                c = Character.toUpperCase(c);
                sb.append(c);
            }
        }
        System.out.print(sb);
    }
}