import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for (int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int distance = 0;
            int velocity = 0;
            
            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                int state = Integer.parseInt(st.nextToken());

                if(state == 0) distance += velocity;
                else if(state == 1){
                    int num = Integer.parseInt(st.nextToken());
                    velocity += num;
                    distance += velocity;
                }
                else{
                    int num = Integer.parseInt(st.nextToken());
                    velocity -= num;
                    if(velocity<0) velocity = 0;
                    distance += velocity;
                }
            }
            sb.append("#").append(t).append(" ").append(distance).append('\n');
        }
        System.out.print(sb);
    }
}