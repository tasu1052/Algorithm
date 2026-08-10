import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        //name, yearning을 맵에 저장 전처리하면 이중 for문으로 풀 수 있을듯?
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<name.length; i++){
            hm.put(name[i], yearning[i]);
        }
        
        int[] ans = new int[photo.length];
        for(int i=0; i<photo.length; i++){
            int sum = 0;
            for(int j=0; j<photo[i].length; j++){
                sum += hm.getOrDefault(photo[i][j], 0);
            }
            ans[i] = sum;
        }
        
        return ans;
    }
}