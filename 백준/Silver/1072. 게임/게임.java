import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());

        long Z = (Y * 100) / X;

        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1_000_000_000;
        long answer = -1;
        
        while(left <= right){
            long mid = (left + right) / 2;

            long newZ = (Y + mid) * 100 / (X + mid);

            if (newZ > Z) {
                answer = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }
        System.out.print(answer);
    }
}