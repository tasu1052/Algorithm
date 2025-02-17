import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            String S = br.readLine();
            int score = 0;
            int n=0;
            for(int j=0; j<S.length(); j++){
                char c = S.charAt(j);
                
                if(c=='O'){
                    n=n+1;
                    score+=n;
                }
                
                else if(c=='X'){
                    n=0;
                }
                
            }
            System.out.println(score);
        }
        
    }
}