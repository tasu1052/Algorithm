import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = (long) N * N;
        long result = 0;

        while(start <= end){
            long mid = (start + end) / 2;
            long cnt = 0;

            for(int i=1; i<=N; i++){
                cnt += Math.min(N, mid/i);
            }

            if(cnt >= k){
                result = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        
        System.out.print(result);
    }
}