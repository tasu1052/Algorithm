import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] line = new int[K];
        
        long max = 0;
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            if (line[i] > max) max = line[i];
        }
        
        long left = 1;
        long right = max;
        long result = 0;
        while(left<=right){
            long mid = (left + right) / 2;
            long total = 0;
            for(int i=0; i<K; i++){
                total += line[i]/mid;
            }
            if(total >= N){
                result = mid;
                left = mid + 1;
            } 
            else
                right = mid - 1;
        }
        System.out.print(result);
    }
}