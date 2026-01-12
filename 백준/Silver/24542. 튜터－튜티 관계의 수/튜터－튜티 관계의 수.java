import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		for(int i=0; i<=N; i++) arr[i] = i;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		int[] count = new int[N+1];
		for(int i=1; i<=N; i++) ++count[find(i)];
		
		long result = 1;
		for(int i=1; i<=N; i++) {
			if(arr[i] == i) result = (result * count[i]) % 1_000_000_007;
		}
		
		System.out.print(result);
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a >= b) arr[a] = b;
		else arr[b] = a;
	}
	static int find(int x) {
		if(x == arr[x]) return x;
		return arr[x] = find(arr[x]);
	}
}