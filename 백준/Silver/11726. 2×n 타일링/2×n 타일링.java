import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long[] D = new long[N+1];//길이 N으로 만들 수 있는 타일의 경우의 수

        D[1] = 1;
        if(N >= 2) D[2] = 2;

        for(int i=3; i<=N; i++){
            D[i] = (D[i-1] + D[i-2]) % 10007;
        }
        
        System.out.print(D[N]);
    }
}