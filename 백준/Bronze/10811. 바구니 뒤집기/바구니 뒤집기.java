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
        
        for(int i=0; i<N;i++)
            arr[i] = i+1;
        
        for(int i=0; i<M; i++){
            StringTokenizer sb = new StringTokenizer(br.readLine(), " ");
        
            int I = Integer.parseInt(sb.nextToken())-1;
            int J = Integer.parseInt(sb.nextToken())-1;
            
            while(I<J){
                int temp = arr[I];
                arr[I] = arr[J];
                arr[J] = temp;
                I++;
                J--;
                }
            }
        for(int i=0; i<N; i++)
            System.out.print(arr[i]+ " ");
    }
}