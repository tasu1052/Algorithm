import java.io.*;
import java.util.*;
  
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int count = 0;

        for(int i=0; i<N; i++){
        	int target = arr[i];
            int start_index = 0, end_index = N - 1;
            
            while(start_index < end_index){

                if(start_index == i){
                    start_index++;
                    continue;
                }
                if(end_index == i){
                    end_index--;
                    continue;
                }
                long sum = arr[start_index] + arr[end_index];
                if (sum == target) {
                    count++;
                    break;
                } else if (sum < target) {
                    start_index++;
                } else {
                    end_index--;
                }
            }
        }
        System.out.print(count);
    }
}