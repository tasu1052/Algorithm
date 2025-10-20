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
            st = new StringTokenizer(br.readLine());
            int[] price = new int[N];
            long sum = 0;
            
            for(int i=0; i<N; i++){
                price[i] = Integer.parseInt(st.nextToken());
            }

            int start = 0;
            int end = N;
            while(start != end){
                int max = Integer.MIN_VALUE;
                for(int i=start; i<end; i++){
                    max = Math.max(max, price[i]);
                }
                int currentIdx = 0;
                for(int i=start; i<end; i++){
                    if(price[i]==max){
                        currentIdx = i;
                        break;
                    }
                }
                for(int i=start; i<currentIdx; i++){
                    sum += max - price[i];
                }
                start = currentIdx + 1;
            }
            sb.append("#").append(t).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
    }
}