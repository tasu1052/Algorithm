import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = 0;
        
        for(int j =0; j<M; j++){
            StringTokenizer sb = new StringTokenizer(br.readLine(), " ");
            int I = Integer.parseInt(sb.nextToken());
            int J = Integer.parseInt(sb.nextToken());
            int K = Integer.parseInt(sb.nextToken());
            
            for(int a=I-1; a<J; a++){
                arr[a]=K;
            }
        }
        
        for(int b=0; b<N; b++)
            System.out.print(arr[b]+ " ");
        
        
        
    }
}