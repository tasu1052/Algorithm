import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> st = new Stack<Integer>();
        
        int N = Integer.parseInt(stn.nextToken());
        
        while(N-- > 0){
            stn = new StringTokenizer(br.readLine(), " ");
            int com = Integer.parseInt(stn.nextToken());
            int x=0;
            
            if(com==1)
                 x = Integer.parseInt(stn.nextToken());
            
            switch(com){
                case 1: st.push(x);
                        break;
                case 2: if(!st.isEmpty()){
                        System.out.println(st.pop());
                        break;
                }
                        else{
                            System.out.println(-1);
                            break;
                           }
                case 3: 
                           System.out.println(st.size());
                           break;
                case 4: if(st.empty()){
                           System.out.println(1);
                           break;
                }
                        else{
                           System.out.println(0);
                            break;
                        }
                case 5:
                           if(!st.empty()){
                               System.out.println(st.peek());
                               break;
                           }
                           else{
                               System.out.println(-1);
                               break;
                           }
            }
        }
    }
}