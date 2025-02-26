import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        for(int i=0; i<N; i++)
            arr[i] = 0;
        
        int i=1;
        int j=0;
        
        while(i<=N){
            if(N%i==0){
                arr[j]=i;
                j++;
            }
            i++;
        }
        System.out.print(arr[K-1]);
    }
}