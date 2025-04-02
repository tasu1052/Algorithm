import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            sb.append(getPrimeNumber(n)).append('\n');
        }
        System.out.print(sb);
    }
    
    public static int getPrimeNumber(int num){
        int size = 246913;
        boolean[] Prime = new boolean[size];
        Prime[0] = Prime[1] = true;
        for(int i=2; i*i < size; i++){
            if(!Prime[i]){
                for(int j=i*i; j<size; j+=i)
                    Prime[j] = true;
            }
        }
        int count=0;
        for(int i=num+1; i<=2*num; i++){
            if(!Prime[i])
                count++;
        }
        return count;
    }
}