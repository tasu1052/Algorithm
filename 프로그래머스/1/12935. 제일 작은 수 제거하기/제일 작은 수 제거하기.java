import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == min) continue;
            ans.add(arr[i]);
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        if(ans.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        }
        
        return answer;
    }
}