import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Deque <String> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while(N-- > 0){
            String S = br.readLine();
            String[] str = S.split(" ");
            
            if(str[0].equals("push"))
                q.offer(str[1]);
            else if(str[0].equals("pop")){
                if(q.isEmpty())
                    sb.append(-1).append('\n');
                else
                    sb.append(q.poll()).append('\n');
            }
            else if(str[0].equals("size"))
                sb.append(q.size()).append('\n');
            else if(str[0].equals("empty")){
                if(q.isEmpty())
                    sb.append(1).append('\n');
                else
                    sb.append(0).append('\n');
            }
            else if(str[0].equals("front")){
                if(q.isEmpty())
                    sb.append(-1).append('\n');
                else
                    sb.append(q.peekFirst()).append('\n');
            }
            else if(str[0].equals("back")){
                if(q.isEmpty())
                    sb.append(-1).append('\n');
                else
                    sb.append(q.peekLast()).append('\n');
            }
        }
        System.out.print(sb);
    }
}