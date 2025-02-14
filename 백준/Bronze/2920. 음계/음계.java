import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] asc = new int[8];
        int[] dsc = new int[8];
        
        for(int i=0; i<asc.length; i++){
            asc[i] = i+1;
        }
        
        int n = 8;
        
        for(int i=0; i<dsc.length; i++){
            dsc[i] = n;
            n--;
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] arr = new int[8];
        
        for(int i=0; i<8; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(Arrays.equals(arr, asc))
            System.out.print("ascending");
        else if(Arrays.equals(arr, dsc))
            System.out.print("descending");
        else
            System.out.print("mixed");
        
    }
}