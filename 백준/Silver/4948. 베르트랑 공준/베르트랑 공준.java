import java.io.*;
import java.util.*;

public class Main {
    public static int size = 246913;
    public static boolean[] Prime = new boolean[size];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        get_Prime();
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            int count = 0;
            
            for(int i=n+1; i<=2*n; i++)
                if(!Prime[i]) count++;
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
    
    public static void get_Prime(){
        Prime[0] = Prime[1] = true;
        for(int i=2; i*i < size; i++){
            if(!Prime[i]){
                for(int j=i*i; j<size; j+=i)
                    Prime[j] = true;
            }
        }
    }
}