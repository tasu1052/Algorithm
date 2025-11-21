import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
   
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        long answer = 0;
        
        for(int i=0; i<N; i++) {
        	arr[i] = arr[i] - B;
        	answer++;
        }
        for(int i=0; i<N; i++){
            if(arr[i]>0){
                answer += arr[i]/C;
                if(arr[i]%C!=0) answer++;
            }
        }
        System.out.print(answer);
    }
}