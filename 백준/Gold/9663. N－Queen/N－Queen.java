import java.io.*;
import java.util.*;

public class Main{
    static int[] arr;
    static int N;
    static int count = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        
        nqueen(0);

        System.out.print(count);
        
    }
    static boolean check(int row){
        for(int i=0; i<row; i++){
            if(arr[i] == arr[row]) return false;
            if(Math.abs(row - i) == Math.abs(arr[i] - arr[row])) return false;
        }
        return true;
    }
    static void nqueen(int row){
        if(row == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            arr[row] = i;
            if(check(row)){
                nqueen(row + 1);
            }
        }
    }
}