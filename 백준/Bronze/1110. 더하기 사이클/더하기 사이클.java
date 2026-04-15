import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int num = N;
        int cnt = 0;

        while(true){
            int remain = num % 10;

            int sum = num / 10 + num % 10;

            num = remain * 10 + sum % 10;

            cnt++;

            if(num == N) break;
        }

        System.out.print(cnt);
    }
}
