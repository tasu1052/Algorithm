import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int max = 0;
            for(int j=1; j<=Math.min(A, B); j++){
                if(A%j==0 && B%j==0)
                    max = j;
            }
            int moda = A/max;
            int modb = B/max;
            int sum = max * moda * modb;
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}