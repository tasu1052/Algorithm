import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static BigInteger K = new  BigInteger("2");
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N =  Integer.parseInt(br.readLine());

        K = K.pow(N).subtract(BigInteger.ONE);
        sb.append(K).append('\n');

        if(N <= 20) dfs(N, 1, 3, 2);

        System.out.print(sb);
    }
    static void dfs(int N, int from, int to, int via){
        if(N == 1){
            sb.append(from + " " + to).append('\n');
            return;
        }

        dfs(N-1, from, via, to);
        sb.append(from + " " + to).append('\n');
        dfs(N-1, via, to, from);
    }
}