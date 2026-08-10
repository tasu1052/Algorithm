import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        HashSet<Character> alpha = new HashSet<>();
        for(int i=0; i<skip.length(); i++){
            alpha.add(skip.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char target = s.charAt(i);
            
            for(int cnt=1; cnt<=index; cnt++){
                target = (char)(((int)(target - 'a' + 1) % 26) + 'a');
                
                if(alpha.contains(target)){
                    cnt--;
                    continue;
                }
            }
            sb.append(target);
        }
        return sb.toString();
    }
}