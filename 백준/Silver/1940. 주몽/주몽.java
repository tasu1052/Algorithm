import java.io.*;
import java.util.*;
  
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int start_index = 0, end_index = arr.length-1, count = 0;

        while(start_index < end_index){
            int num = arr[start_index] + arr[end_index];

            if(num == M){
                count++;
                end_index--;
            }
            else if(num < M){
                start_index++;
            }
            else{
                end_index--;
            }
        }
        System.out.print(count);
    }
}