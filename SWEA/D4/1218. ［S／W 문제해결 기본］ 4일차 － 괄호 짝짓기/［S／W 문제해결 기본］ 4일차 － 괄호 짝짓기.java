import java.io.*;
import java.util.*;
  
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            char[] c = br.readLine().toCharArray();
     
            sb.append("#").append(t).append(" ");
            
            if(N%2 != 0){
                sb.append(0).append('\n');
                continue;
            }
            
            Stack<Character> st = new Stack<>();
            boolean check = true;
            for(int i=0; i<N; i++){
                if(c[i]=='(' || c[i]=='{' || c[i]=='[' || c[i]=='<'){
                    st.push(c[i]);
                    continue;
                }
                if(st.isEmpty()){
                    check = false;
                    break;
                }
                if(st.peek()=='(' && c[i]==')'){
                    st.pop();
                } else if(st.peek()=='{' && c[i]=='}'){
                    st.pop();
                } else if(st.peek()=='[' && c[i]==']'){
                    st.pop();
                } else if(st.peek()=='<' && c[i]=='>'){
                    st.pop();
                } else{
                    check = false;
                    break;
                }
            }

            if(check) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }
        System.out.print(sb);
    }
}