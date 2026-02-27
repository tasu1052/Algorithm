import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int comLength = commands.length;
        int[] answer = new int[comLength];
        
        for(int i=0; i<comLength; i++){
            int[] subArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(subArr);
            answer[i] = subArr[commands[i][2]-1];
        }
        return answer;
    }
}