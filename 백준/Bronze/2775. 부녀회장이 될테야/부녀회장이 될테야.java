import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            int k= Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[k+1][n];
          
            for(int j=0; j<n; j++)
                arr[0][j] = j+1;
            
            for(int j=1; j<=k; j++){
                for(int m=0; m<n; m++){
                    for(int s=0; s<=m; s++)
                arr[j][m] += arr[j-1][s];
                }
            }
            sb.append(arr[k][n-1]).append('\n');
        }
        
        System.out.print(sb);
    }
}