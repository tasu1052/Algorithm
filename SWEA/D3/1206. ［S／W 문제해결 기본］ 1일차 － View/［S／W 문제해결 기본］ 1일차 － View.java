import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] Building = new int[N];

            for(int i=0; i<N; i++){
                Building[i] = Integer.parseInt(st.nextToken());
            }
            
            int count = 0;
            for(int i=2; i<N-2; i++){
                if(Building[i]<Building[i+1] || Building[i]<Building[i+2] ||
                  Building[i]<Building[i-1] || Building[i]<Building[i-2])
                    continue;
                
                int rightMax = Math.max(Building[i+1], Building[i+2]);
                int leftMax = Math.max(Building[i-1], Building[i-2]);
                int finalMax = Math.max(rightMax, leftMax);

                count += Math.abs(Building[i] - finalMax);
            }
            sb.append("#").append(t).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
    }
}