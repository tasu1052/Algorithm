import java.io.*;
import java.util.*;

public class Solution {
    static int[][] arr = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String[] grade = new String[]{"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            Double[] score = new Double[N];
            
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                double total = Integer.parseInt(st.nextToken()) * 0.35 +
                    Integer.parseInt(st.nextToken()) * 0.45 +
                    Integer.parseInt(st.nextToken()) * 0.2;
                
                score[i] = total;
            }
            double targetScore = score[K-1];
            
            Arrays.sort(score, Collections.reverseOrder());

            int idx = 0;
            for(int i=0; i<N; i++){
                if(i != 0 && i%(N/10) == 0) idx++;
                if(score[i] == targetScore)
                    sb.append("#").append(t).append(" ").append(grade[idx]).append('\n');
            }
            
        }
        System.out.print(sb);
    }
}