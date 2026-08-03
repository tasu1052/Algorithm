import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        //우선순위 큐 사용해서 모든 음식 넣기
        //두개씩 꺼내서 계산하고 K 보다 낮으면 다시 넣기
        //이때 처음 꺼낸 음식이 K보다 크면 break하고 섞은 횟수 return
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        int cnt = 0;
        while(true){
            if(pq.size() < 2 && pq.peek() < K) return -1;
            
            int first = pq.poll();
            if(first >= K) return cnt;
            int second = pq.poll();
            
            int newFood = first + (second * 2);
            
            cnt++;
            pq.add(newFood);
        }
    }
}