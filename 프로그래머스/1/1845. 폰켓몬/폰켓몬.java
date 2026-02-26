import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        
        int answer = 0;
        int idx = 0;
        for(int key : hm.keySet()){
            idx++;
            if(idx > nums.length / 2) break;
            answer++;
        }
        return answer;
    }
}