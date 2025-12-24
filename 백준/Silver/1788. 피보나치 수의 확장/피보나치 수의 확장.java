import java.io.*;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        int absN = Math.abs(N);

        long[] fib = new long[absN + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= absN; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
        }

        int sign;
        if (N > 0) sign = 1;
        else sign = (absN % 2 == 0) ? -1 : 1;

        System.out.println(sign);
        System.out.println(fib[absN]);
    }
}
