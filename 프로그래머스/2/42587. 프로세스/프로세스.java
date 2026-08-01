import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++){
            q.add(new int[]{i, priorities[i]});
        }
        
        int order = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            boolean higher = false;
            
            for(int[] next : q){
                if(next[1] > cur[1]){
                    higher = true;
                    break;
                }
            }
            
            if(higher){
                q.add(cur);
            }
            else{
                order++;
                
                if(cur[0] == location){
                    return order;
                }
            }
        }
        return -1;
    }
}