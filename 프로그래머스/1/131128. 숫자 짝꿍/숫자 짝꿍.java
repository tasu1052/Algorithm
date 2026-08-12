import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        //X, Y를 int로 변환하고 int[]에 각각 몇개 있는지 세고
        //Math.min 하면 그냥 나오는거 아닌가?
        //그다음 char 배열로 정렬 후 stringBuilder로 나타내기
        StringBuilder sb = new StringBuilder();
        int[] cntX = new int[10];
        int[] cntY = new int[10];
        
        for(int i=0; i<X.length(); i++){
            cntX[X.charAt(i) - '0']++;
        }
        
        for(int i=0; i<Y.length(); i++){
            cntY[Y.charAt(i) - '0']++;
        }
        
        for(int i=0; i<10; i++){
            int cnt = Math.min(cntX[i], cntY[i]);//i라는 수가 몇개 공통되는지
            for(int j=0; j<cnt; j++){
                sb.append(i);
            }
        }
        
        if(sb.length() == 0) {
            sb.append(-1);
            return sb.toString();
        }
        
        boolean isZero = true;
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(c != '0'){
                isZero = false;
                break;
            }
        }
        
        if(isZero){
            sb = new StringBuilder();
            sb.append(0);
        }
        
        char[] tmp = sb.toString().toCharArray();
        Arrays.sort(tmp);
        
        StringBuilder sortedSb = new StringBuilder(new String(tmp)).reverse();
        return sortedSb.toString();
    }
}