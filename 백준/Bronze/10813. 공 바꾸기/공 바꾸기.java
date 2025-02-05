import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = i+1;
        
        for(int j =0; j<M; j++){
            StringTokenizer sb = new StringTokenizer(br.readLine(), " ");
            int I = Integer.parseInt(sb.nextToken());
            int J = Integer.parseInt(sb.nextToken());
            
            int temp = arr[I-1];
            arr[I-1]=arr[J-1];
            arr[J-1]=temp;
        }
        
        for(int b=0; b<N; b++)
            System.out.print(arr[b]+ " ");
        
    }
}