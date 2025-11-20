import java.io.*;
import java.util.*;

public class Solution {
    static int[] num = new int[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
   
        for(int t=1; t<=T; t++){
            char[] c = br.readLine().toCharArray();

            boolean check = true;
            for(int i=0, j=c.length-1; i<c.length/2; i++, j--){
                if(c[i] != c[j]){
                    check = false;
                    break;
                }
            }
            if(check) sb.append("#").append(t).append(" ").append(1).append('\n');
            else sb.append("#").append(t).append(" ").append(0).append('\n');
        }
        System.out.print(sb);
    } 
}