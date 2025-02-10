import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] arr = new int[9][9];
        
        for(int i=0; i<9; i++){
            StringTokenizer st= new StringTokenizer(br.readLine(), " ");
            
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());    
            }
        }
        
        int max=-1;
        int[] maxIndexArray = new int[2];
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(arr[i][j] > max){
                    max = arr[i][j];
                    maxIndexArray[0] = i+1;
                    maxIndexArray[1] = j+1;
                }
            }
        }
        
        System.out.println(max);
        System.out.print(maxIndexArray[0] + " " + maxIndexArray[1]);
    }
}