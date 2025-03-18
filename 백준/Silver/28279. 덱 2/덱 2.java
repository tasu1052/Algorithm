import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        while(N-- > 0){
            String S = br.readLine();
            String[] str = S.split(" ");
            
            if(str[0].equals("1"))
                q.offerFirst(str[1]);
            else if(str[0].equals("2"))
                q.offerLast(str[1]);
            else if(str[0].equals("3")){
                if(!q.isEmpty())
                    sb.append(q.pollFirst()).append('\n');
                else
                    sb.append(-1).append('\n');
            }
            else if(str[0].equals("4")){
                if(!q.isEmpty())
                    sb.append(q.pollLast()).append('\n');
                else
                    sb.append(-1).append('\n');
            }
            else if(str[0].equals("5"))
                sb.append(q.size()).append('\n');
            else if(str[0].equals("6")){
                if(q.isEmpty())
                    sb.append(1).append('\n');
                else
                    sb.append(0).append('\n');
            }
            else if(str[0].equals("7")){
                if(!q.isEmpty())
                    sb.append(q.peekFirst()).append('\n');
                else
                    sb.append(-1).append('\n');
            }
            else if(str[0].equals("8")){
                if(!q.isEmpty())
                    sb.append(q.peekLast()).append('\n');
                else
                    sb.append(-1).append('\n');
            }
        }
        System.out.print(sb);
    }
}