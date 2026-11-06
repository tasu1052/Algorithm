import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int answer = 0;
        
        for(int i=0; i<priorities.length; i++){
            q.offer(new int[]{i, priorities[i]});
        }
        
        while(true){
            int[] now = q.poll();
            
            boolean flag = true;
            for(int[] tmp : q){
                if(tmp[1] > now[1]){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                answer++;
                if(now[0] == location) break;
            }
            else{
                q.add(now);
            }
        }
        return answer;
    }
}