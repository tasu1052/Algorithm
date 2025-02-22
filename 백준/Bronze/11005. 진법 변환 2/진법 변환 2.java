import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        StringBuilder sb= new StringBuilder();
        int n;
        
        while(B > 0){
            n = B%N;
            
            if(n>=10)
                sb.append((char)(n-10+'A'));
            else
                sb.append(n);
        
            B /= N;
        }
        
        System.out.print(sb.reverse().toString());
        
    }
}