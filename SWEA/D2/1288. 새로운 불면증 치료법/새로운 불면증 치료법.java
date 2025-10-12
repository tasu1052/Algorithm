import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=T; i++){
            int origin = Integer.parseInt(br.readLine());
            boolean[] arr = new boolean[10];
            int idx = 1;

            while(true){
                int current = origin * idx;
                String check = String.valueOf(current);

                for(int j=0; j<check.length(); j++){
                    arr[check.charAt(j) - '0'] = true;
                }

                boolean allSeen = true;
                for(boolean b : arr){
                    if(!b){
                        allSeen = false;
                        break;
                    }
                }

                if(allSeen){
                    sb.append("#").append(i).append(" ").append(current).append('\n');
                    break;
                }

                idx++;
            }
        }
        System.out.print(sb);
    }
}
