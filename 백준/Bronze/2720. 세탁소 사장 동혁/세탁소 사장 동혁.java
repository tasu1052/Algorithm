import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
       for(int i=0; i<T; i++){
           int m = Integer.parseInt(br.readLine());
           int[] arr = new int[]{0, 0, 0, 0};
           
           arr[0] = m/25;
           arr[1] = (m%25)/10;
           arr[2] = ((m%25)%10)/5;
           arr[3] = ((m%25)%10)%5;
           
           for(int j=0; j<arr.length; j++)
               System.out.print(arr[j] + " ");
           
           System.out.println();
       }
        
    }
}