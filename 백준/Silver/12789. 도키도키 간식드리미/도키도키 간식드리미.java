import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        
        int[] arr = new int[N];
        int min=1;
        
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(stn.nextToken());
            
            if(arr[i]==min){
                min++;
                while(!st.isEmpty() && st.peek() == min){
                    st.pop();
                    min++;
                }
            }
            else
                st.push(arr[i]);
        }
        
         if(st.isEmpty())
                sb.append("Nice").append('\n');
            else
                sb.append("Sad").append('\n');
        
        System.out.print(sb);
        
    }
}