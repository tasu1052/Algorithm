import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[] arr = new int[5];
        int sum=0;
        
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum+=arr[i];
        }
        
        int avg = sum / 5;
        
        sb.append(avg).append('\n');
        
        for(int i=0; i<4; i++){
            for(int j=i+1; j<5; j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
        sb.append(arr[2]);
        
        System.out.print(sb);
    }
}