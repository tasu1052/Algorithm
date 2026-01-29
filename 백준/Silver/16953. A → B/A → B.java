import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
	
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {A, 1});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int value = now[0];
			int cnt = now[1];
			
			if(value == B) {
				System.out.println(cnt);
				return;
			}
			
			if((long)value * 2 <= B) q.add(new int[] {value * 2, cnt + 1});
			if((long)value * 10 + 1 <= B) q.add(new int[] {value * 10 + 1, cnt + 1});
		}
		System.out.println(-1);
	}
}
