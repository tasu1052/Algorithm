import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int sum = 1;

        sb.append(sum).append(" ");
        
        for(int i=0; i<N; i++){
            sum = sum * 2; 
            sb.append(sum).append(" ");
        }
        System.out.print(sb);
    }
}