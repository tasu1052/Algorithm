import java.io.*;
import java.util.*;

public class Main{
    static int[][] arr = new int[10][10];
    static int ans = Integer.MAX_VALUE;
    static int[] paper = new int[]{0, 5, 5, 5, 5, 5};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);

        if(ans == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(ans);
        
    }
    static void backtracking(int xy, int useCnt){
        if(xy == 100){
            ans = Math.min(useCnt, ans);
            return;
        }
        int x = xy % 10;
        int y = xy / 10;

        if(ans <= useCnt) return;
        if(arr[y][x] == 1){
            for(int i=5; i>0; i--){
                if(paper[i]>0 && check(x, y, i)){
                    paper[i]--;
                    fill(x, y, i, 0);
                    backtracking(xy + 1, useCnt + 1);
                    paper[i]++;
                    fill(x, y, i, 1);
                }
            }
        }
        else{
            backtracking(xy + 1, useCnt);
        }
    }
    static void fill(int x, int y, int size, int num){
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                arr[i][j] = num;
            }
        }
    }
    static boolean check(int x, int y, int size){
        if(x+size > 10 || y+size > 10) return false;
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(arr[i][j] != 1) return false;
            }
        }
        return true;
    }
}