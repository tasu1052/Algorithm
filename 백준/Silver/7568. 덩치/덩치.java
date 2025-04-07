import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        StringBuilder sb = new StringBuilder();
        int[] count = new int[N];
        for (int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                if(arr[i][0]<arr[j][0] && arr[i][1] < arr[j][1])
                    count[i]++;
            }
            sb.append(count[i] + 1).append(' ');
        }
        System.out.print(sb);
    }
}