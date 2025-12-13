import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        long start = 1;
        long end = arr[N-1];
        long result = 0;

        while(start <= end){
            long mid = (start + end) / 2;
            long cnt = 0;

            for(int i=0; i<N; i++){
                if(arr[i] / mid > 0){
                    cnt += arr[i] / mid;
                }
                if(cnt > M) break;
            }

            if(cnt >= M){
                result = mid;
                start = mid + 1;
            }
            else end = mid - 1;
            
        }
        
        System.out.print(result);
    }
}