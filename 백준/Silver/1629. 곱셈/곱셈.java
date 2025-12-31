import java.io.*;
import java.util.*;

public class Main {
    static int C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long sum = pow(A, B);

        System.out.print(sum);
    }
    static long pow(int a, int b){
        if(b == 0) return 1;

        long half = pow(a, b / 2);
        long result = (half * half) % C;

        if(b % 2 == 1) result = (result * a) % C;

        return result;
    }
}
