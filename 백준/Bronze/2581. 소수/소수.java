import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        
        int count=0;
        
        for(int i=M; i<=N; i++){
            boolean check = true;
            
            if(i==1) continue;
            
            for(int j=2; j*j<=i;j++){
                if(i%j==0){
                    check = false;
                    break;
                }
            }
            
            if(check == true)
                count++;
        }
       
        if(count==0){
            System.out.print(-1);
            return;
        }
        
        int[] arr = new int[count];
        int sum=0;
        int index=0;
        
        for (int i = M; i <= N; i++) {
            boolean check = true;
            if (i == 1) continue; 
            
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                arr[index++] = i; 
                sum += i;          
            }
        }
        
        System.out.println(sum);
        System.out.print(arr[0]);
    }
}