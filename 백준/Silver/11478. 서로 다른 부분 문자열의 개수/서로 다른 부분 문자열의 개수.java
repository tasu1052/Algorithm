import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        HashSet <String> hs = new HashSet<>();

        for(int i=0; i< S.length(); i++){
            char c = S.charAt(i);
            hs.add(Character.toString(c));
        }
        
        int index = 2;
        while(index<=S.length()){
            for(int i=0; i<S.length()-1; i++){
                if(i+index == S.length()+1)
                    break;
                String str = S.substring(i, i+index);
                hs.add(str);
                    
            }
            index++;
        }
        
        System.out.print(hs.size());
    }
}