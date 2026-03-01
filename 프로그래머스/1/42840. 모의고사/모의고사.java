import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] person = new int[3][];
        person[0] = new int[]{1, 2, 3, 4, 5};
        person[1] = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        person[2] = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] max = new int[3];
        
        for(int i=0; i<3; i++){
            int idx = 0;
            for(int j=0; j<answers.length; j++){
                if(person[i][idx++] == answers[j]){
                    max[i]++;
                }
                idx %= person[i].length;
            }
        }
        
        int maxScore = Math.max(max[0], Math.max(max[1], max[2]));
        
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max[i] == maxScore) arr.add(i + 1);
        }

        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) answer[i] = arr.get(i);
        
        return answer;
    }
}