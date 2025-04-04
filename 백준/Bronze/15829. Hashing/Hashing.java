import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 1234567891;
        final int R = 31;
        
        int L = Integer.parseInt(br.readLine());
        String S = br.readLine();
        
        long hash = 0;
        long power = 1;

        for (int i = 0; i < L; i++) {
            int c = S.charAt(i) - 'a' + 1;
            hash = (hash + c * power) % MOD;
            power = (power * R) % MOD;
        }

        System.out.println(hash);
    }
}