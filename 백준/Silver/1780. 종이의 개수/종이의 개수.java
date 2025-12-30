import java.io.*;
import java.util.*;

public class Main {
    static int minusCnt = 0;
    static int zeroCnt = 0;
    static int oneCnt = 0;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(N, 0, 0);

        System.out.println(minusCnt);
        System.out.println(zeroCnt);
        System.out.print(oneCnt);
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
            if(num == -1) minusCnt++;
            else if(num == 0) zeroCnt++;
            else oneCnt++;
            return;
        }

        int half = n / 3;
        int half2 = (2 * n) / 3;
        dfs(half, x, y);
        dfs(half, x, y + half);
        dfs(half, x, y + half2);
        dfs(half, x + half, y);
        dfs(half, x + half, y + half);
        dfs(half, x + half, y + half2);
        dfs(half, x + half2, y);
        dfs(half, x + half2, y + half);
        dfs(half, x + half2, y + half2);
    }
}