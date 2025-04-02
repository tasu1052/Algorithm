import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Stack <String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(N-- > 0){
            String S = br.readLine();
            String[] str = S.split(" ");
            
            if(str[0].equals("push"))
                st.push(str[1]);
            else if(str[0].equals("pop")){
                if(st.isEmpty())
                    sb.append(-1).append('\n');
                else
                    sb.append(st.pop()).append('\n');
            }
            else if(str[0].equals("size"))
                sb.append(st.size()).append('\n');
            else if(str[0].equals("empty")){
                if(st.isEmpty())
                    sb.append(1).append('\n');
                else
                    sb.append(0).append('\n');
            }
            else if(str[0].equals("top")){
                if(st.isEmpty())
                    sb.append(-1).append('\n');
                else
                    sb.append(st.peek()).append('\n');
            }
        }
        System.out.print(sb);
    }
}