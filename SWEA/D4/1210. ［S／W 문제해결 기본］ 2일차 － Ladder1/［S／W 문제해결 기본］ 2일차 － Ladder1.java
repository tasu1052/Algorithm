import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        for(int t=1; t<=T; t++){
            int tc = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];

            for(int i=0; i<100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int finalIdx = 0;;
            for(int i=0; i<100; i++){
                if(arr[99][i] == 2){
                    finalIdx = i;
                    break;
                }
            }
            int rowIdx = 99;
            int currentRowIdx = rowIdx;
            
            while(currentRowIdx != 0){
                currentRowIdx--;
                if(finalIdx-1 < 0){
                    if(arr[currentRowIdx][finalIdx+1] == 1){
                        for(int i=finalIdx; i <= 99 && arr[currentRowIdx][i] == 1; i++){
                            finalIdx = i;
                        }
                    }
                }
                else if(finalIdx + 1 > 99){
                    if(arr[currentRowIdx][finalIdx-1] == 1){
                        for(int i=finalIdx; i >= 0 && arr[currentRowIdx][i] == 1; i--){
                            finalIdx = i;
                        }
                    }
                }
                else{
                    if(arr[currentRowIdx][finalIdx-1] == 1){
                        for(int i=finalIdx; i >= 0 && arr[currentRowIdx][i] == 1; i--){
                            finalIdx = i;
                        }
                    }
                    else if(arr[currentRowIdx][finalIdx+1] == 1){
                        for(int i=finalIdx; i <= 99 && arr[currentRowIdx][i] == 1; i++){
                            finalIdx = i;
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(finalIdx).append('\n');
        }
        System.out.print(sb);
    }
}