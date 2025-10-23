import java.io.*;
import java.util.*;
 
public class Solution {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            arr = new char[8][8];
            
            for(int i=0; i<8; i++){
                String line = br.readLine();
                for(int j=0; j<8; j++){
                    arr[i][j] = line.charAt(j);
                }
            }
            
            int count = 0;
            for (int i=0; i<8; i++){ //가로 회문 검사
                int start = 0;
                for(int j=start; j<8-N+1; j++){
                    boolean check = true;
                    for(int k=j, l=j+N-1; k<j+N/2; k++, l--){
                        if(arr[i][k] != arr[i][l]){
                            check = false;
                            break;
                        }
                    }
                    if(check) count++;
                }
            }

            for (int i=0; i<8; i++){ //세로 회문 검사
                int start = 0;
                for(int j=start; j<8-N+1; j++){
                    boolean check = true;
                    for(int k=j, l=j+N-1; k<j+N/2; k++, l--){
                        if(arr[k][i] != arr[l][i]){
                            check = false;
                            break;
                        }
                    }
                    if(check) count++;
                }
            }
            
            sb.append("#").append(t).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
    }
}