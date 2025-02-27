import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        while(true){
            int n = Integer.parseInt(br.readLine());
            
            if(n==-1)
                break;
            int count=0;
            
            for(int i=1; i<n; i++){
                if(n%i==0)
                    count++;
            }
            
            int[] arr = new int[count];
            int sum=0;
            int j=0;
            for(int i=1; i<n; i++){
                if(n%i==0){
                    arr[j++]=i;
                    sum+=i;
                }
            }
            if(sum==n){
                System.out.print(n + " = ");
                for(int i=0; i<count; i++){
                    if(arr[i]==n/2)
                        System.out.println(arr[i]);
                    else
                        System.out.print(arr[i] + " + ");
                }
            }
            else
                System.out.println(n + " is NOT perfect.");
            
            
        }
    }
}