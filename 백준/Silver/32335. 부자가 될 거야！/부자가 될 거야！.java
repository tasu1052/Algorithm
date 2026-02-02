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
		
		int[] dial = new int[N];
		String s = br.readLine();
		for(int i=0; i<N; i++) dial[i] = s.charAt(i) - '0';
		
		if(M == 0) {
			for(int n : dial) System.out.print(n);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(dial[i] == 0 && i != N-1) continue;
			
			int gap = 10 - dial[i];
			
			if(M >= gap) {
				M -= gap;
				dial[i] += gap;
				if(dial[i] >= 10) dial[i] -= 10;
			}
			
			if(i == N-1 && M > 0) {
				dial[i] += M;
				if(dial[i] >= 10) dial[i] %= 10;
			}
		}
		for(int n : dial) System.out.print(n);
	}
}