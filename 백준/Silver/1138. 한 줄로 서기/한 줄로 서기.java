import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=N-1; i>=0; i--) list.add(arr[i], i + 1);
        
        for(int num : list) sb.append(num).append(" ");
        
        System.out.println(sb);
    }
}