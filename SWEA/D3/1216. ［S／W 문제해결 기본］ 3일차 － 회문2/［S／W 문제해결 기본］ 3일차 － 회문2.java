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
            char[][] arr = new char[100][100];
            
            for(int i=0; i<100; i++){
                String line = br.readLine();
                for(int j=0; j<100; j++){
                    arr[i][j] = line.charAt(j);
                }
            }

            int checkLength = 100;

            findPalindrome:
            while(checkLength > 0){
                for(int i=0; i<100; i++){
                    for(int j=0; j<=100-checkLength; j++){
                        boolean rowCheck = true;
                        boolean colCheck = true;

                        for(int k=j, l=checkLength-1+j; k<l; k++, l--){
                            if(arr[i][k] != arr[i][l]) rowCheck = false;
                            if(arr[k][i] != arr[l][i]) colCheck = false;
                        }
                        if(rowCheck || colCheck){
                            sb.append("#").append(tc).append(" ").append(checkLength).append('\n');
                            break findPalindrome;
                        }
                    }
                }
                checkLength--;
            }
        }
        System.out.print(sb);
    }
}