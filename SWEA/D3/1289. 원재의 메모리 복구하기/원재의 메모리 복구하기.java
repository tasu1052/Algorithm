import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        for(int t=1; t<=T; t++){
            String answer =  br.readLine();
            int[] answerMemory = new int[answer.length()];
            int[] initailize = new int[answer.length()];

            for(int i=0; i<answer.length(); i++){
                answerMemory[i] = answer.charAt(i)-'0';
            }

            int checkIdx = 0;
            int count = 0;
            while(checkIdx<answer.length()){
                if(initailize[checkIdx] != answerMemory[checkIdx]){
                    for(int i=checkIdx; i<answer.length(); i++){
                        if(initailize[i]==0) initailize[i] = 1;
                        else initailize[i] = 0;
                    }
                    checkIdx++;
                    count++;
                }
                else{
                    checkIdx++;
                }
            }
            
            sb.append("#").append(t).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
    }
}