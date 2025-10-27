import java.io.*;
import java.util.*;
  
public class Solution {
    static int highIndex, lowIndex;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
          
        for(int t=1; t<=T; t++){
            int dumpCount = Integer.parseInt(br.readLine());
            arr = new int[100];
            st = new StringTokenizer(br.readLine());
            //필요한 변수 초기화
 
            for(int i=0; i<100; i++){//배열 내부 값 넣기
                arr[i] = Integer.parseInt(st.nextToken());
            }
 
            int diff = 0;
             
            for(int i=0; i<dumpCount; i++){
                find();
                arr[highIndex]--;
                arr[lowIndex]++;
                find();
                 
                diff = arr[highIndex] - arr[lowIndex];
                if(diff <= 1) break;
            }//최고-최저 찾는 로직
             
            sb.append("#").append(t).append(" ").append(diff).append('\n');
        }
        System.out.print(sb);
    }
    static void find(){//최고, 최저점 인덱스 및 값 찾는 로직
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
         
        for(int i=0; i<100; i++){
            if(high < arr[i]){
                high = arr[i];
                highIndex = i;
            }
            if(low > arr[i]){
                low = arr[i];
                lowIndex = i;
            }
        }
    }
}