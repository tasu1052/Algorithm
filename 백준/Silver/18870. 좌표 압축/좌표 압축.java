import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] Sorted = arr.clone();
        Arrays.sort(Sorted);
        
        HashMap<Integer, Integer> ranking = new HashMap<Integer, Integer>();
        
        int count = 0;
        
        for(int v: Sorted){
            if(!ranking.containsKey(v)){
                ranking.put(v, count);
                count++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int key: arr){
            int rank = ranking.get(key);
            sb.append(rank).append(' ');
        }
        
        System.out.print(sb);
        
    }
}