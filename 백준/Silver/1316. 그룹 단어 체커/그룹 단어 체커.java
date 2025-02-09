import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int count=0;
        
        for(int i=0; i<N; i++){
            String S = br.readLine();
            char[] str = S.toCharArray();
            boolean[] alpha = new boolean[26];
            boolean d = true;
            char prev='\0';
            
            for(int j=0; j<str.length; j++){
                char now = str[j];
                
                if(prev != now){
                    if(alpha[now - 'a'] == false){
                        alpha[now - 'a'] = true;
                        prev = now;
                    }
                    else
                        d = false;
                        
                }
            }
            
            if( d == true)
                count++;
        }
        System.out.print(count);
    }
}