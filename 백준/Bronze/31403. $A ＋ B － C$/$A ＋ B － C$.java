import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        String a = A + "";
        String b = B + "";
        String c = C + "";
        String ab;
        int AB;
        
        ab = a + b;
        AB = Integer.parseInt(ab);
        
        System.out.println(A+B-C);
        System.out.print(AB-C);
    }
}