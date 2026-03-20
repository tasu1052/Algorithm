import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 1) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                one(idx, arr);
            } else {
                arr = two(arr);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void one(int idx, int[][] arr) {
        int tmp = arr[idx][N - 1];
        for (int j = N - 1; j > 0; j--) {
            arr[idx][j] = arr[idx][j - 1];
        }
        arr[idx][0] = tmp;
    }

    static int[][] two(int[][] arr) {
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res[j][N - 1 - i] = arr[i][j];
            }
        }
        return res;
    }
}