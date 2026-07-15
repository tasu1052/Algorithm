import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<Character> st = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '('){
                st.addLast(c);
            } 
            else{
                if(st.isEmpty() || st.peekLast() == c){
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }
        
        if(!st.isEmpty()) return false;

        return answer;
    }
}