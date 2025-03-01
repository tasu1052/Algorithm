import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int line1 = Integer.parseInt(st.nextToken());
            int line2 = Integer.parseInt(st.nextToken());
            int line3 = Integer.parseInt(st.nextToken());
            
            if(line1==0 && line2==0 && line3 ==0)
                break;
            
            int[] arr = new int[3];
            
            arr[0]=line1;
            arr[1]=line2;
            arr[2]=line3;
            
            int max = arr[0];
            for(int i=1; i<3; i++){
                if(max<arr[i])
                    max = arr[i];
            }
            int sum=arr[0]+arr[1]+arr[2]-max;
            
            if(sum<=max){
                System.out.println("Invalid");
                continue;
            }
                    
            if((line1==line2 && line2==line3 && line3==line1))
                System.out.println("Equilateral");
            else if((line1==line2 || line2==line3 || line3==line1))
                System.out.println("Isosceles");
            else if((line1!=line2 && line2!=line3 && line3!=line1))
                System.out.println("Scalene");
        }
    }
}