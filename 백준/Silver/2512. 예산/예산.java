import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        long M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        if(sum <= M){
            System.out.print(arr[N-1]);
            return;
        }
        
        long start = 1;
        long end = arr[N-1];
        long result = 0;

        while(start <= end){
            long mid = (start + end) / 2;
            long total = 0;

            for(int i=0; i<N; i++){
                if(arr[i] < mid) total += arr[i];
                else total += mid;
            }

            if(total <= M){
                result = mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }
        
        System.out.print(result);
    }
}