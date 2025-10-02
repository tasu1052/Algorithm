import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int A, B;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if(A>B) sb.append("#").append(i+1).append(" >").append('\n');
            else if(A<B) sb.append("#").append(i+1).append(" <").append('\n');
            else sb.append("#").append(i+1).append(" =").append('\n');
        }
        System.out.print(sb);
    }
}