import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());

        String S = br.readLine();
        
        int sum=0;
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            sum += (c-96)*Math.pow(31, i);
        }
        
        System.out.print(sum);
    }
}