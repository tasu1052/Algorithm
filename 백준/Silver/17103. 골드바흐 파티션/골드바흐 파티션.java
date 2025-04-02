import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            
            sb.append(get_Partition(n)).append('\n');
        }
        System.out.print(sb);
    }
    
    public static int get_Partition(int n){
        boolean[] Prime = new boolean[n+1];
        Prime[0] = Prime[1] = true;
        
        for(int i=2; i*i < Prime.length; i++){
            if(!Prime[i]){
                for(int j=i*i; j<Prime.length; j+=i)
                    Prime[j] = true;
            }
        }
        int count = 0;
        for(int i=2; i<Prime.length; i++){
            if(!Prime[i]){
                if(!Prime[n-i] && n-i<=i)
                    count++;
            }
        }
        return count;
    }
}