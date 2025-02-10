import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];
        int[][] sum = new int[N][M];
        for(int i=0; i<N; i++){
            StringTokenizer s1 = new StringTokenizer(br.readLine(), " ");
            
            for(int j=0; j<M;j++){
                arr1[i][j] = Integer.parseInt(s1.nextToken());
            }
        }
        
        for(int i=0; i<N; i++){
            StringTokenizer s2 = new StringTokenizer(br.readLine(), " ");
            
            for(int j=0; j<M;j++){
                arr2[i][j] = Integer.parseInt(s2.nextToken());
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        for(int i=0; i<sum.length; i++){
            for(int j=0; j<sum[i].length; j++){
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        
        
    }
}