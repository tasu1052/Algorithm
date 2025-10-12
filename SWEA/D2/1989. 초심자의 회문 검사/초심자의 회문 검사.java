import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int i=1; i<=T; i++){
            String str = br.readLine();
            String[] arr = str.split("");

            boolean alltrue = true;
            for(int j=0; j<Math.ceil(arr.length/2.0); j++){
                if(!arr[j].equals(arr[arr.length-1-j])){
                    alltrue =false;
                    break;
                }
            }
            if(alltrue)
                sb.append("#").append(i).append(" ").append(1).append('\n');
            else
                sb.append("#").append(i).append(" ").append(0).append('\n');
            
        }
        System.out.print(sb);
    }
}