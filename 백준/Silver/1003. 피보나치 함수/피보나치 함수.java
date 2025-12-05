import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int num = Integer.parseInt(br.readLine());
            fib(num);
        }
        
        System.out.print(sb);
    }
    static void fib(int n){
        int[][] arr = new int[n+1][2];

        if(n>=0){
            arr[0][0] = 1;
            arr[0][1] = 0;
        }
        if(n>=1){
            arr[1][0] = 0;
            arr[1][1] = 1;
        }
        if(n>=2){
            for(int i=2; i<n+1; i++){
                arr[i][0] = arr[i-2][0] + arr[i-1][0];
                arr[i][1] = arr[i-2][1] + arr[i-1][1];
            }
        }
        sb.append(arr[n][0]).append(" ").append(arr[n][1]).append('\n');
    }
}