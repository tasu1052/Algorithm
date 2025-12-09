import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        int total = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            total += arr[i];
        }

        int start = max;
        int end = total;

        while(start <= end){
            int mid = (start + end) / 2;
            int cnt = 0;
            int sum = 0;
            for(int i=0; i<N; i++){
                if(sum + arr[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if(sum != 0) cnt++;
            if(cnt > M) start = mid + 1;
            else end = mid -1;
        }
        System.out.print(start);
    }
}