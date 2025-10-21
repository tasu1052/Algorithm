import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            
            for(int i=0; i<N; i++){
                String S = br.readLine();
                for(int j=0; j<N; j++){
                    arr[i][j] = S.charAt(j) - '0';
                }
            }

            int start = (N-1)/2;
            int end = (N-1)/2;
            int sum = 0;
            int idx = 0;
            
            while(idx<N){
                if(idx<=(N-1)/2){
                    for(int i=start; i<=end; i++){
                        sum += arr[idx][i];
                    }
                    if(idx == (N-1)/2){
                        start++;
                        end--;
                    }
                    else{
                        start--;
                        end++;
                    }
                    idx++;
                    
                }
                else{
                    for(int i=start; i<=end; i++){
                        sum += arr[idx][i];
                    }
                    start++;
                    end--;
                    idx++;
                }
            }
            
            sb.append("#").append(t).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
    }
}