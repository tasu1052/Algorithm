import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        int[] sum = new int[N];
        for(int i=0; i<N; i++){
            for(int j=0; j<=i; j++){
                sum[i] += arr[j];
            }
        }

        int answer = 0;
        for(int c : sum){
            answer += c;
        }
        System.out.print(answer);
    }
}