import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[] arr = new boolean[42];
        int[] n = new int[10];
        
        for(int i=0; i<42; i++){
            arr[i] = false;
        }
        
        for(int i=0; i<10; i++){
            n[i] = Integer.parseInt(br.readLine());
            n[i] = n[i]%42;
            arr[n[i]] = true;
        }
        
        int count =0;
        
        for(int i=0; i<42; i++){
            if(arr[i]==true)
                count++;
        }
        
        System.out.print(count);
        
    }
}