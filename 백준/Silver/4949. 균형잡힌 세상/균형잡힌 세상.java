import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true){
            String S = br.readLine();
            if(S.equals("."))
                break;
            
            if(check(S))
                sb.append("yes").append('\n');
            else
                sb.append("no").append('\n');
        }
        
        System.out.print(sb.toString());
        
    }
    
    public static boolean check(String S){
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            
            if(c == '(' || c == '[')
                st.push(c);
                
            if(c == ')'){
                if(st.isEmpty()){
                    return false;
                }
                else{
                    if(st.peek()=='['){
                        return false;
                    }
                    else
                        st.pop();
                }
            }
                
            if(c == ']'){
                if(st.isEmpty()){
                    return false;
                }
                else{
                    if(st.peek()=='('){
                        return false;
                    }
                    else
                        st.pop();
                }
            }
        }   
        
        if(st.isEmpty())
            return true;
        else
            return false;
        
    }
}