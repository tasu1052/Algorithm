import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());

            long p = 10;
            while (x >= p) {
                long r = x % p;
                if (r >= p / 2) x = (x / p + 1) * p;
                else x = (x / p) * p;
                p *= 10;
            }

            sb.append(x).append('\n');
        }
        System.out.print(sb);
    }
}