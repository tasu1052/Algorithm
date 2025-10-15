import java.io.*;
import java.util.*;

public class Solution {
    static int[][] arr = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int t=1; t<=T; t++){
            for(int i=0; i<9; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<9; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            sb.append("#").append(t).append(" ");
            
            if(check()) sb.append(1);
            else sb.append(0);

            sb.append('\n');
        }
        
        System.out.print(sb);
    }
    public static boolean check(){
        for(int i=0; i<9; i++){
            boolean[] num = new boolean[10];
            for(int j=0; j<9; j++){
                if(!num[arr[i][j]]) num[arr[i][j]] = true;
                else return false;
            }
        }
        
        for(int i=0; i<9; i++){
            boolean[] num = new boolean[10];
            for(int j=0; j<9; j++){
                if(!num[arr[j][i]]) num[arr[j][i]] = true;
                else return false;
            }
        }

        for(int i=0; i<9; i=i+3){
            for(int j=0; j<9; j=j+3){
                boolean[] num = new boolean[10];
                for(int k=i; k<i+3; k++){
                    for(int l=j; l<j+3; l++){
                        if(!num[arr[k][l]]) num[arr[k][l]] = true;
                        else return false;
                    }
                }
            }
        }
        return true;
    }
}