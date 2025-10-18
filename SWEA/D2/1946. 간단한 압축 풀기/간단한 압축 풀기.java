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
            int[] count = new int[N];
            char[] tempAlpah = new char[N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                tempAlpah[i] = st.nextToken().charAt(0);
                count[i] = Integer.parseInt(st.nextToken());
            }
            
            int sum = 0;
            for(int i=0; i<N; i++){
                sum += count[i];
            }

            int idx = 0;
            char[] alphabet = new char[sum];
            for(int i=0; i<N; i++){
                for(int j=0; j<count[i]; j++){
                    alphabet[idx] = tempAlpah[i];
                    idx++;
                }
            }

            sb.append("#").append(t).append("\n");
            
            int num = 0;
            for(int i=0; i<alphabet.length; i++){
                sb.append(alphabet[i]);
                num++;
                if(num == 10){
                    sb.append('\n');
                    num = 0;
                }
            }
            if(num!=0) sb.append('\n');
        }
        System.out.print(sb);
    }
}