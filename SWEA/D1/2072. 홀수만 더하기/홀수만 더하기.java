import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j=0; j<arr.length; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                if(arr[j]%2!=0){
                    sum+=arr[j];
                }
            }
            sb.append("#").append(i+1).append(" ").append(sum)
                .append('\n');
        }
        System.out.print(sb);
    }
}