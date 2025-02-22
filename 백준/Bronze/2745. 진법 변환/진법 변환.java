import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String B = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        
        int sum=0;
        for(int i=0; i< B.length(); i++){
            char c = B.charAt(i);
            int num;
            
            if(Character.isDigit(c))
                num = c - '0';
            else
                num = c - 55;
            sum+=num*(int)Math.pow(N,B.length() -1 -i);
        }
        
        System.out.print(sum);
        
    }
}