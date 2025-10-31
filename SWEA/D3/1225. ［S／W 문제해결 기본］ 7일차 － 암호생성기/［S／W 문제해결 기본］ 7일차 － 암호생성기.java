import java.io.*;
import java.util.*;
    
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
            
        for(int t=1; t<=T; t++){
            int tc = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<8; i++){
                deque.offerLast(Integer.parseInt(st.nextToken()));
            }
            
            Label:
            while(true){
                for(int i=1; i<=5; i++){
                    int a = deque.pollFirst() - i;

                    if(a<=0){
                        a = 0;
                        deque.offerLast(a);
                        break Label;
                    }
                    deque.offerLast(a);
                }
            }
            sb.append("#").append(tc).append(" ");
            for(int i=0; i<8; i++){
                sb.append(deque.pollFirst()).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}