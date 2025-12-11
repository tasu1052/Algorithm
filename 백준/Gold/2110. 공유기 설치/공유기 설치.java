import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int sum = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = 1;
        int max = arr[N-1] - arr[0];

        int start = min;
        int end = max;
        int result = 0;
        
        while(start <= end){
            int mid = (start + end) / 2;

            int cnt = 1;
            int last = arr[0];

            for(int i=1; i<N; i++){
                if(arr[i] - last >= mid){
                    cnt++;
                    last = arr[i];
                }
            }
            if(cnt >= C){
                result = mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }
        
        System.out.print(result);
    }
}