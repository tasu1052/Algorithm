import java.io.*;
import java.util.*;
  
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        
        for(int i=1; i<=N; i++) arr[i] = i;

        int count = 1;
        int start=1, end=1, sum=1;

        while(end!=N){
            if(sum==N){
                end++;
                sum = sum + end;
                count++;
            }
            else if(sum>N){
                sum = sum - start;
                start++;
            }
            else{
                end++;
                sum = sum + end;
            }
        }
        System.out.print(count);
    }
}