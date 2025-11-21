import java.io.*;
import java.util.*;

public class Solution {
    static int[] num = new int[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
   
        String[] grade = new String[] {"A+", "A0", "A-", "B+","B0",
        		"B-", "C+", "C0", "C-", "D0"};
        
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            Double[] studentScore = new Double[N];
            
            for(int i=0; i<N; i++) {
            	st = new StringTokenizer(br.readLine());
            	double total = 0.35 * Integer.parseInt(st.nextToken()) +
            			0.45 * Integer.parseInt(st.nextToken()) + 
            					0.2 * Integer.parseInt(st.nextToken());
            	studentScore[i] = total;
            }
            double targetScore = studentScore[K-1];
            Arrays.sort(studentScore, (a,b)-> Double.compare(b,a));
            
            for(int i=0; i<N; i++) {
            	if(studentScore[i] == targetScore) {
            		sb.append("#").append(t).append(" ")
            		.append(grade[(int)(i/(N/10))]).append('\n');
            		break;
            	}
            }
        }
        System.out.print(sb);
    }
}