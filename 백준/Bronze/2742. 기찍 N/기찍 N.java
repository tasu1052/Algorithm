import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int num = N;
        for(int i=0; i<N; i++){
            sb.append(num--).append('\n');
        }

        System.out.print(sb);
    }
}
