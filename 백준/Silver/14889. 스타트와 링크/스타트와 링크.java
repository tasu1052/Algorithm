import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int ts;
    static int tl;
    static boolean[] picked;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        picked = new boolean[N];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0,0);

        System.out.print(min);
    }

    static void backtracking(int idx, int cnt) {
        int startsum = 0;
        int linksum = 0;;
        
        if(cnt == N/2){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(picked[i]&&picked[j]) startsum += arr[i][j];
                    if(!picked[i]&&!picked[j]) linksum += arr[i][j];
                }
            }
            min = Math.min(min, Math.abs(startsum - linksum));
            return;
        }

        for(int i=idx; i<N; i++){
            if(!picked[i]){
                picked[i] = true;
                backtracking(i + 1, cnt+1);
                picked[i] = false;
            }
        }
    }
}
