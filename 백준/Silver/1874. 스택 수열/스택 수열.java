import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int start = 0;
        
        while (n-- > 0) {
            int value = Integer.parseInt(br.readLine());
            
            if(value > start){
                for(int i=start+1; i<=value; i++){
                    st.push(i);
                    sb.append("+").append('\n');
                }
                start = value;
            }
            else if(st.peek() != value){
                System.out.println("NO");
                return;
            }
            st.pop();
            sb.append("-").append('\n');
        }
        System.out.print(sb);
    }
}