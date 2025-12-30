import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    static int[][] arr;
    static int row, column;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        dfs((int)Math.pow(2, N), 0, 0);
    }
    static void dfs(int n, int x, int y){
        if(x == row && y == column){
            System.out.print(cnt);
            return;
        }
        if(row < x || row >= x + n || column < y || column >= y + n){
            cnt += n * n;
            return;
        }
        if(n == 1){
            cnt++;
            return;
        }

        int half = n / 2;
        dfs(half, x, y);
        dfs(half, x, y + half);
        dfs(half, x + half, y);
        dfs(half, x + half, y + half);
       
    }
}