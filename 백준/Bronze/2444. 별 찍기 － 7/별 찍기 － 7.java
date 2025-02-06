import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int k = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < (N - i); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < k; j++) {
                System.out.print("*");
            }
            System.out.println();
            
            k = k + 2;

            if (k == 2 * N + 1) {
                k = 2 * N -1;
                for (int j = 1; j <= N; j++) {
                    k -= 2;
                    for (int l = 0; l < j; l++) {
                        System.out.print(" ");
                    }
                    for (int l = 0; l < k; l++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }
    }
}
