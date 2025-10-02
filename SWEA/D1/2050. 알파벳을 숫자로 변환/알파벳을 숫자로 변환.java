import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            sb.append(c-64).append(" ");
        }
        System.out.print(sb);
    }
}