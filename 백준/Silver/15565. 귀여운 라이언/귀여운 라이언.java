import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int s = 0;
		int e = 0;
		int oneCnt = (arr[0] == 1) ? 1 : 0;
		int minAns = Integer.MAX_VALUE;
		
		while(true) {
			if(oneCnt < K) {
				if(e == N - 1) break;
				e++;
				if(arr[e] == 1) oneCnt++;
			} else {
				int length = e - s + 1;
				minAns = Math.min(minAns, length);
				if(arr[s] == 1) oneCnt--;
				s++;
			}
			
		}
		if(minAns == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minAns);
	}
}