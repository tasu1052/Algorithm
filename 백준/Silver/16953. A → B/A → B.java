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
	
		int cnt = 1;
		
		while(B > A) {
			if(B % 10 ==1) {
				B = (B - 1) / 10;
			} else if(B % 2 == 0) {
				B /= 2;
			} else {
				System.out.println(-1);
				return;
			}
			cnt++;
		}
		
		if(B == A) System.out.println(cnt);
		else System.out.println(-1);
	}
}
