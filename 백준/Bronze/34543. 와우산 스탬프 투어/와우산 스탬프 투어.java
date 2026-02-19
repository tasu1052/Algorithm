import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int W = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		sum += N * 10;
		if(N >= 3) sum += 20;
		if(N == 5) sum += 50;
		if(W > 1000) {
			if(sum <= 15) sum = 0;
			else sum -= 15;
		}
		
		System.out.println(sum);
	}
}
