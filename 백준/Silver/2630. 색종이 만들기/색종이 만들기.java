import java.io.*;
import java.util.*;

public class Main {
    static int whiteCnt = 0;
    static int blueCnt = 0;
    static int[][] arr;
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

        System.out.println(whiteCnt);
        System.out.print(blueCnt);
    }
    static void dfs(int n, int x, int y){
        int color = arr[x][y];
        boolean same = true;
        
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(arr[i][j] != color){
                    same = false;
                    break;
                }
            }
            if(!same) break;
        }

        if(same){
            if(color == 0) whiteCnt++;
            else blueCnt++;
            return;
        }

        int half = n / 2;
        dfs(half, x, y);
        dfs(half, x, y + half);
        dfs(half, x + half, y);
        dfs(half, x + half, y + half);
    }
}