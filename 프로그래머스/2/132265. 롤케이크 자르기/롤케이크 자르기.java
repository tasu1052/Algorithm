import java.util.*;
class Solution {
    public int solution(int[] topping) {
        //map 두개 만들어서 하나에 모든 topping 다 넣어놓고
        //topping 순회하면서 하나씩 반대 세트에 옮기면서 그때마다 size 검사
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> second = new HashMap<>();
        
        int answer = 0;
        
        for(int i=0; i<topping.length; i++){
            first.put(topping[i], first.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i=0; i<topping.length; i++){
            first.put(topping[i], first.getOrDefault(topping[i], 0) - 1);
            if(first.get(topping[i]) == 0){
                first.remove(topping[i]);
            }
            second.put(topping[i], second.getOrDefault(topping[i], 0) + 1);
            
            if(first.size() == second.size()){
                answer += 1;
            }
        }
        return answer;
    }
}