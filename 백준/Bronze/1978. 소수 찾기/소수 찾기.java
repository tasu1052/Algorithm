import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int count=0;
        
        for(int num : arr){
            if(num==1)
                continue;
            
            boolean check = true;
            for(int i=2; i*i<=num;i++){
                if(num%i==0)
                    check = false;
            }
            if(check == true)
                count++;
        }
        System.out.print(count);
    }
}