import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        boolean[] visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        int sum = 0;
        int maxIdx = 0;
        for(int i=0; i<N; i++){
            int max = 0;
            for(int j=0; j<N; j++){
                if(B[j] > max && !visited[j]){
                    max = B[j];
                    maxIdx = j;
                }
            }
            sum += A[i] * max;
            visited[maxIdx] = true;
        }
        System.out.print(sum);
    }
}