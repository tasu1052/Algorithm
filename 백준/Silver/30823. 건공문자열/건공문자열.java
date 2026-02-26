import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String S = br.readLine();

        int cut = K - 1; // 0-index로 자르는 위치
        String suffix = S.substring(cut);
        String prefix = S.substring(0, cut);

        StringBuilder sb = new StringBuilder(N);
        sb.append(suffix);

        if ( (N - cut) % 2 == 0 ) {          // 짝수
            sb.append(prefix);
        } else {                              // 홀수
            sb.append(new StringBuilder(prefix).reverse());
        }

        System.out.println(sb.toString());
    }
}