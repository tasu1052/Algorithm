import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        //cards 뭉치마다 인덱스 놓고 하나씩 넣으면 될거 같은데
        int goalIdx = 0;
        int idx1 = 0, idx2 = 0;
        while(goalIdx < goal.length){
            String target = goal[goalIdx];
            if(idx1 < cards1.length && target.equals(cards1[idx1])){
                idx1++;
            }
            else if(idx2 < cards2.length && target.equals(cards2[idx2])){
                idx2++;
            }
            else{
                return "No";
            }
            goalIdx++;
        }

        return "Yes";
    }
}