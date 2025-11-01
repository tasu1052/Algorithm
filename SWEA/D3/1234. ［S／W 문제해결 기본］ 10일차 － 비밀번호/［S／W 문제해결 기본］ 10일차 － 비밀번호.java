import java.io.*;
import java.util.*;
    
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
            
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            Stack<Character> stack = new Stack<>();
            String S = st.nextToken();
            
            for(int i=0; i<S.length(); i++){
                if(stack.isEmpty()) stack.push(S.charAt(i));
                else{
                    if(stack.peek() == S.charAt(i)){
                        stack.pop();
                    }
                    else stack.push(S.charAt(i));
                }
            }

            StringBuilder result = new StringBuilder();

            for (char c : stack) result.append(c);

            sb.append("#").append(t).append(" ").append(result).append('\n');
        }
        System.out.print(sb);
    }
}