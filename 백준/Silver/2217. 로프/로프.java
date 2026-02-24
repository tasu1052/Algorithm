import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] rope = new int[N];
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			rope[i] = n;
		}
		
		Arrays.sort(rope);
		
		long ans = 0;
		
		
		for(int i=0; i<N; i++) { //로프 선택 개수
			int max = rope[N-1-i]; // 그 로프에서 버틸 수 있는 최소값 저장 변수
			
			ans = Math.max(ans, max * (i+1)); // 답 갱신
		}
		
		System.out.println(ans);
	}
}