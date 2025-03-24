import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        String[] S = new String[N];
    
        for(int i=0; i<N; i++){
            S[i] = br.readLine();
        }
        
        Arrays.sort(S, (s1, s2)->{
            if(s1.length()==s2.length()){
                return s1.compareTo(s2);
            }
            else{
                return s1.length() - s2.length();
            }
        });
        
        sb.append(S[0]).append('\n');
        for(int i=1; i<N; i++){
            if(!S[i].equals(S[i-1]))
                sb.append(S[i]).append('\n');
        }
        
        System.out.print(sb);
        
    }
}