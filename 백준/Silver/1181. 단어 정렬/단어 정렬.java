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
        String[] SortedS = new String[N];
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                if(S[i].length()>S[j].length()){
                    String tmp = S[i];
                    S[i] = S[j];
                    S[j] = tmp;
                }
                else if(S[i].length() == S[j].length()){
                    if(S[i].compareTo(S[j])>0){
                        String tmp = S[i];
                        S[i] = S[j];
                        S[j] = tmp;
                    }
                }
            } 
            SortedS[i] = S[i];
        }
        
        SortedS = Arrays.stream(SortedS).distinct().toArray(String[]::new);
        
        for(int i=0; i<SortedS.length; i++){
            sb.append(SortedS[i]).append('\n');
        }
        
        System.out.print(sb);
        
    }
}