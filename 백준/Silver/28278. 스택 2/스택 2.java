import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> st = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        
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
                        sb.append(st.pop()).append('\n');
                        break;
                }
                        else{
                            sb.append(-1).append('\n');
                            break;
                           }
                case 3: 
                           sb.append(st.size()).append('\n');
                           break;
                case 4: if(st.isEmpty()){
                           sb.append(1).append('\n');
                           break;
                }
                        else{
                           sb.append(0).append('\n');
                            break;
                        }
                case 5:
                           if(!st.isEmpty()){
                               sb.append(st.peek()).append('\n');
                               break;
                           }
                           else{
                               sb.append(-1).append('\n');
                               break;
                           }
            }
        }
        System.out.print(sb.toString());
    }
}