import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] road = new int[N-1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++) road[i] = Integer.parseInt(st.nextToken());
        
        int[] city = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) city[i] = Integer.parseInt(st.nextToken());

        long cost = 0;
        int minPrice = city[0];

        for(int i=0; i<N-1; i++){
            minPrice = Math.min(minPrice, city[i]);
            cost += minPrice * road[i];
        }
        
        System.out.print(cost);
    }
}