import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        boolean[] losted = new boolean[n + 1];
        boolean[] reserved = new boolean[n + 1];
        
        for(int x : lost) losted[x] = true;
        for(int x : reserve) reserved[x] = true;
        
        for(int i=1; i<=n; i++){
            if(losted[i] && reserved[i]){
                losted[i] = false;
                reserved[i] = false;
            }
        }
        
        for(int i=1; i<=n; i++){
            if(!losted[i]) continue;
            
            if(i - 1 >= 1 && reserved[i-1]){
                losted[i] = false;
                reserved[i-1] = false;
            } else if(i + 1 <= n && reserved[i+1]){
                losted[i] = false;
                reserved[i+1] = false;
            }
        }
            
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            if(!losted[i]) answer++;
        }
        
        return answer;
    }
}