import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[100][100];
        
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                arr[i][j] = 0;
            }
        }
        
        int width = 0;
        
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for(int j=N; j<N+10; j++){
                for(int k=M; k<M+10; k++){
                    arr[j][k] = 1;
                }
            }
        }
        
        for(int l=0; l<100; l++){
                for(int m=0; m<100; m++){
                    if(arr[l][m]==1)
                        width++;
                }
            }
        
        System.out.print(width);
        
    }
}