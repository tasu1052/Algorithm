import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();
        
        int N = Integer.parseInt(br.readLine());
        int n;
        
        while(N-- > 0){
            String S = br.readLine();
            String[] input = S.split(" ");
            
            if(input[0].equals("push")){
                q.offer(Integer.parseInt(input[1]));
            }
            else if(input[0].equals("pop")){
                if(q.isEmpty())
                    sb.append(-1).append('\n');
                else
                    sb.append(q.poll()).append('\n');
            }
            else if(input[0].equals("size")){
                sb.append(q.size()).append('\n');
            }
            else if(input[0].equals("empty")){
                if(q.isEmpty())
                    sb.append(1).append('\n');
                else
                    sb.append(0).append('\n');
            }
            else if(input[0].equals("front")){
                if(q.isEmpty())
                    sb.append(-1).append('\n');
                else
                    sb.append(q.peek()).append('\n');
            }
            else if(input[0].equals("back")){
                if(q.isEmpty())
                    sb.append(-1).append('\n');
                else
                    sb.append(q.peekLast()).append('\n');  
            }
        }
        System.out.print(sb);
    }
}