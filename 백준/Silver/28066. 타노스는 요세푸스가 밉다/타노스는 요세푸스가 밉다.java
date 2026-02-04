import java.io.*;
import java.util.*;

public class Main {
	static char[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=N; i++) q.add(i);
		
		while(true) {
			int first = q.poll();
			
			if(q.size() + 1 < K) {
				System.out.println(first);
				return;
			}
			
			for(int i=0; i<K-1; i++) q.poll();
			
			if(q.size() >= 1) q.add(first);
			else {
				System.out.println(first);
				return;
			}
		}
	
	}
}