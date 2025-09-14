import java.io.*;
import java.util.*;

public class Main{
    static boolean[][] arr;
    static int N;
    static int count;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        arr = new boolean[N][N];
        
        nqueen(0);

        System.out.print(count);
        
    }
    static boolean isSafe(int row, int col){
        for(int i=0; i<row; i++){
            if(arr[i][col]) return false;
        }

        for(int i=row-1, j=col-1; i>=0&&j>=0; i--, j--){
            if(arr[i][j]) return false;
        }

        for(int i=row-1, j=col+1; i>=0 && j < N; i--, j++){
            if(arr[i][j]) return false;
        }
        return true;
    }
    static void nqueen(int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            if(isSafe(depth, i)){
                arr[depth][i] = true;
                nqueen(depth+1);
                arr[depth][i] = false;
            }
        }
    }
}