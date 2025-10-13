import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int i=1; i<=T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] Narr = new int[N];
            int[] Marr = new int[M];
            
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                Narr[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                Marr[j] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            int max = Integer.MIN_VALUE;
            if(N<M){
                for(int j=0; j<=(Marr.length-Narr.length); j++){
                    int idx = j;
                    for(int k=0; k<Narr.length; k++){
                        sum += Marr[idx] * Narr[k];
                        idx++;
                    }
                    if(sum>max) max = sum;
                    sum = 0;
                }
            }
            else{
                for(int j=0; j<=(Narr.length-Marr.length); j++){
                    int idx = j;
                    for(int k=0; k<Marr.length; k++){
                        sum += Narr[idx] * Marr[k];
                        idx++;
                    }
                    if(sum>max) max = sum;
                    sum = 0;
                }
            }
            sb.append("#").append(i).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
    }
}