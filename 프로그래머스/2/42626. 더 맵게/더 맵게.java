import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> q = new PriorityQueue<>((a, b) -> {
            return Long.compare(a, b);
        });
        
        for(int i=0; i<scoville.length; i++) q.add((long)scoville[i]);
        
        int answer = 0;
        
        while(!q.isEmpty() && q.peek() < K){
            if(q.size() < 2) return -1;
            
            long first = q.poll();
            long second = q.poll();
            
            long newFood = first + (second * 2);
            
            q.add(newFood);
            answer++;
        }
        return answer;
    }
}