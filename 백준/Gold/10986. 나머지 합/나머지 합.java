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

        long[] sumArr = new long[N+1];
        long[] count = new long[M];

        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i-1] + num;
        }

        for(int i=1; i<=N; i++){
            int remainder = (int)(sumArr[i] % M);
            if(remainder == 0) answer++;
            count[remainder]++;
        }

        for(int i=0; i<M; i++){
            if(count[i]>1){
                answer += count[i] * (count[i]-1)/2;
            }
        }
        System.out.print(answer);
    }
}
