import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st1.nextToken());
        int X = Integer.parseInt(st1.nextToken());
        
        int[] arr = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st2.nextToken());
        }
        
        for(int i=0; i<N; i++){
            if(arr[i]<X)
                System.out.print(arr[i] + " ");
        }
        
    }
}