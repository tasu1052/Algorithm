import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        sb.append(avg(N, arr)).append('\n');
        sb.append(mid(N, arr)).append('\n');
        sb.append(most(N, arr)).append('\n');
        sb.append(range(N, arr)).append('\n');

        System.out.print(sb);
    }
    
    static int avg(int n, int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++)
            sum += arr[i];
        double avg = (double)sum/n;
        return (int)Math.round(avg);
    }
    
    static int mid(int n, int[] arr){
        Arrays.sort(arr);
        return arr[n/2];
    }

    static int most(int n , int[] arr){
        int[] count = new int[8001];
        
        for(int i=0; i<arr.length; i++){
            count[arr[i]+4000]++;
        }
        int max = 0;
        for(int i=0; i<count.length; i++){
            if(max<count[i])
                max = count[i];
        }
        Queue <Integer> q = new LinkedList<>();
        for (int i=0; i<count.length; i++) {
            if(max==count[i])
                q.offer(i-4000);
        }
        if(q.size() == 1) return q.poll();
        else{
            q.poll();
            return q.poll();
        }
            
    }

   static int range(int n, int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            if(arr[i]>max)
                max = arr[i];
            if(arr[i]<min)
                min = arr[i];
        }
        return max-min;
    }
}