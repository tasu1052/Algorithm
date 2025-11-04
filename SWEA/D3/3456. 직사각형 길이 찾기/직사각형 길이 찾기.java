import java.io.*;
import java.util.*;
     
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
             
        for(int t=1; t<=T; t++){
            int[] arr = new int[101];
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                arr[Integer.parseInt(st.nextToken())]++;
            }
            
            sb.append("#").append(t).append(" ");
            for(int i=1; i<101; i++){
                if(arr[i] % 2 ==1) sb.append(i);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}