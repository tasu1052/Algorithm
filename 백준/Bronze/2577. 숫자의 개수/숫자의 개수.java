import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = new int[10];
        
        for(int i=0; i<arr.length; i++)
            arr[i] = 0;
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        String S = A*B*C + "";
        
        String[] str = S.split("");
        
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            arr[c - '0'] += 1;
        }
        
        for(int i=0; i< arr.length; i++)
            System.out.println(arr[i]);
    }
}