import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = new int[5];
        int sum = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += (arr[i]) * (arr[i]);
        }
        
        int total;
        
        total = sum % 10;
        
        System.out.print(total);
    }
}