import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        long left = 0;
        long right = Integer.MAX_VALUE;
        long ans = 0;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long cnt = 0;

            for(int i=0; i<N; i++){
                cnt += arr[i] / mid;
            }

            if(cnt >= K){
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        System.out.print(ans);
    }
}