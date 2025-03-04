import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        
        int[] arr = new int[N];
        int index=0;
        
        while(st.hasMoreTokens()){
            arr[index++]=Integer.parseInt(st.nextToken());
        }
        
        int max=0;
        
        for(int i=0; i<arr.length; i++){
            for(int j=i+1;j<arr.length; j++){
                for(int k=j+1;k<arr.length; k++){
                    if(((arr[i]+arr[j]+arr[k])<=M)&&(arr[i]+arr[j]+arr[k])>max){
                        max=arr[i]+arr[j]+arr[k];
                    }
                }
            }
        }
        System.out.print(max);
    }
}