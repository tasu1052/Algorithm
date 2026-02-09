import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int K = Integer.parseInt(s, 2);
		
		int calCnt = 0;
		
		while(K != 0) {
			//연산
			K = K-(K&((~K) + 1));
			calCnt++;
		}
		System.out.println(calCnt);
	}
}