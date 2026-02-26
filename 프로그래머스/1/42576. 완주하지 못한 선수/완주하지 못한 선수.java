import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0; i<participant.length; i++){
            hm.put(participant[i], hm.getOrDefault(participant[i], 0) + 1);
        }
        
        for(int i=0; i<completion.length; i++){
            hm.put(completion[i], hm.getOrDefault(completion[i], 0) - 1);
            if(hm.get(completion[i]) <= 0) hm.remove(completion[i]);
        }
        
        String answer = "";
        
        for(String key : hm.keySet()){
            answer = key;
        }
        
        return answer;
    }
}