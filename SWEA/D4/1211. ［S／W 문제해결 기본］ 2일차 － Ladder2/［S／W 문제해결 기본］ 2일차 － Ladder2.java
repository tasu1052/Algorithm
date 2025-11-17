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

            int start = 0;
            int min = Integer.MAX_VALUE;
            
            for(int i=0; i<100; i++){
                if(arr[99][i] == 1){
                    int count = 0;
                    int finalIdx = i;
                    
                    int rowIdx = 99;
                    int currentRowIdx = rowIdx;
             
                    while(currentRowIdx != 0){
                        currentRowIdx--;
                        count++;
                        if(finalIdx-1 < 0){
                            if(arr[currentRowIdx][finalIdx+1] == 1){
                                for(int j=finalIdx; j <= 99 && arr[currentRowIdx][j] == 1; j++){
                                    finalIdx = j;
                                    count++;
                                }
                            }
                        }
                        else if(finalIdx + 1 > 99){
                            if(arr[currentRowIdx][finalIdx-1] == 1){
                                for(int j=finalIdx; j >= 0 && arr[currentRowIdx][j] == 1; j--){
                                    finalIdx = j;
                                    count++;
                                }
                            }
                        }
                        else{
                            if(arr[currentRowIdx][finalIdx-1] == 1){
                                for(int j=finalIdx; j >= 0 && arr[currentRowIdx][j] == 1; j--){
                                    finalIdx = j;
                                    count++;
                                }
                            }
                            else if(arr[currentRowIdx][finalIdx+1] == 1){
                                for(int j=finalIdx; j <= 99 && arr[currentRowIdx][j] == 1; j++){
                                    finalIdx = j;
                                    count++;
                                }
                            }
                        }
                    }
                    if(min>count){
                        min = count;
                        start = finalIdx;
                    }
                }
            }
            
            sb.append("#").append(tc).append(" ").append(start).append('\n');
        }
        System.out.print(sb);
    }
}