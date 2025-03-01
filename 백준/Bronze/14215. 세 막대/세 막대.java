import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[3];
        
        arr[0]=a;
        arr[1]=b;
        arr[2]=c;
        
        int max = arr[0];
            
        for(int i=1; i<3; i++){
            if(max<arr[i])
                max=arr[i];
        }
        
        int sum=a+b+c-max;
        
        while(sum<=max){
            max--;
        }
        
        int total=sum+max;
        
        System.out.print(total);
       
    }
}