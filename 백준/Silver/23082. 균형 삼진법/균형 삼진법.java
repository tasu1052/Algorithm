import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		if (N == 0) {
		    System.out.println(0);
		    return;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		while(N != 0) {
			int now = N % 3;
			
			if (now == 2) {
                now = -1;
            } 
			else if (now == -2) {
                now = 1;
            }
			
			list.add(now);
			N = (N - now) / 3;
		}
		
		for(int i=list.size()-1; i>=0; i--) {
			if(list.get(i) == -1) sb.append("T");
			else sb.append(list.get(i));
		}
		
		System.out.println(sb);
	}
}
