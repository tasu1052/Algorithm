import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        int left = 0;
        int right = N-1;
        long best = Long.MAX_VALUE;
        int ansL = 0, ansR = 0;

        while(left < right){
            long sum = arr[left] + arr[right];

            if (Math.abs(sum) < best) {
                best = Math.abs(sum);
                ansL = left;
                ansR = right;
            }
            
            if(sum == 0) break;
            else if(sum > 0) right--;
            else left++;
        }
        sb.append(arr[ansL]).append(" ").append(arr[ansR]);
        System.out.print(sb);
    }
}