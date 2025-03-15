import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<Integer>();
        
        int K = Integer.parseInt(br.readLine());
        int sum =0;
        int n=0;
        while(K-- > 0){
            n = Integer.parseInt(br.readLine());
            
            if(n==0){
                st.pop();
                continue;
            }
            st.push(n);
        }
        
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        System.out.print(sum);
    }
}