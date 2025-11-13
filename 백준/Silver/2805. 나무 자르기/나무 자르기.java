import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            if(tree[i] > max) max = tree[i];
        }

        Arrays.sort(tree);

        int low = 0;
        int high = max;
        int answer = 0;

        while(low <= high){
            int mid = (low + high) / 2;
            long sum = 0;

            for(int h : tree){
                if(h>mid) sum += (h-mid);
            }

            if(sum >= M){
                answer = mid;
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        
        System.out.print(answer);
    }
}
