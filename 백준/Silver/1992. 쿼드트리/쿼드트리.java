import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        dfs(N, 0, 0);

        System.out.print(sb);
    }
    static void dfs(int n, int x, int y){
        int num = arr[x][y];
        boolean same = true;

        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(arr[i][j] != num){
                    same = false;
                    break;
                }
            }
            if(!same) break;
        }

        if(same){
            if(num == 0) sb.append(0);
            else sb.append(1);
            return;
        }
        sb.append("(");
        int half = n / 2;
        dfs(half, x, y);
        dfs(half, x, y + half);
        dfs(half, x + half, y);
        dfs(half, x + half, y + half);
        sb.append(")");
    }
}