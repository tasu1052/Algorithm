import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        StringBuilder sb = new StringBuilder();
        
        ArrayDeque<Integer> st = new ArrayDeque<>();
        
        for(int i=0; i<arr.length; i++){
            if(st.isEmpty() || st.peekLast() != arr[i]) st.offer(arr[i]);
            else if(st.peekLast() == arr[i]) continue;
        }
        
        int[] ans = new int[st.size()];
        for(int i=0; i<ans.length; i++) ans[i] = st.poll();

        return ans;
    }
}