import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        BigInteger fact = BigInteger.ONE;
        for(int i=2; i<=n; i++){
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        
        String s = fact.toString();
        int count = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == '0') count++;
            else break;
        }
        System.out.print(count);
    }
}