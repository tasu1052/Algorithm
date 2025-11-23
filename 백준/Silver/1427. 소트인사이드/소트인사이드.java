import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        int[] arr = new int[s.length()];

        for(int i=0; i<arr.length; i++){
            arr[i] = s.charAt(i) - '0';
        }

        for(int i=0; i<arr.length; i++){
            int max = 0;
            int maxIdx = 0;
            for(int j=i; j<arr.length; j++){
                if(arr[j] >= max){
                    max = arr[j];
                    maxIdx = j;
                }
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;

            sb.append(arr[i]);
        }
        System.out.print(sb);
    }
}
