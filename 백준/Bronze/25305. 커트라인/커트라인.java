import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        int[] win = new int[k];
        
        Arrays.sort(arr);
        
        for(int i=0; i<k; i++){
            win[i] = arr[arr.length-1 - i];
        }
        
        System.out.print(win[win.length-1]);
        
    }
}