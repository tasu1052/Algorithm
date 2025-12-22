import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[N+1];

        D[1] = arr[1];

        int ans = arr[1];
        
        for(int i=2; i<=N; i++){
            D[i] = Math.max(arr[i], D[i-1] + arr[i]);
            ans = Math.max(ans, D[i]);
        }
        System.out.print(ans);
    }
}