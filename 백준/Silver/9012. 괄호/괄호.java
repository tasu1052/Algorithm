import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
            String S = br.readLine();
            if(check(S))
                sb.append("YES").append('\n');
            else
                sb.append("NO").append('\n');
        }
        
        System.out.print(sb.toString());
        
    }
    
    public static boolean check(String S){
        Stack<String> st = new Stack<String>();
        String[] input = S.split("");
            
        for(int i=0; i<input.length; i++){
            if(input[i].equals(")")){
                if(st.isEmpty()){
                    return false;
                }
                else
                    st.pop();
            }
            else{
                st.push(input[i]);
            }
        }
        if(st.isEmpty())
            return true;
        else
            return false;
            
    }
}