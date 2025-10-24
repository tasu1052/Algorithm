import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[j][i] == 1){
                        for(int k=j+1; k<N; k++){
                            if(arr[k][i] == 2){
                                count++;
                                j = k;
                                break;
                            }
                        }
                    }
                }
            }
            
            
            sb.append("#").append(t).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
    }
}