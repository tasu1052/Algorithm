import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int sum = N / 3;
            sb.append("#").append(t).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
    }
}