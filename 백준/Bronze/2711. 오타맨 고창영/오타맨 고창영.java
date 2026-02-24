import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int location = Integer.parseInt(st.nextToken()) - 1;
			String[] s = st.nextToken().split("");
			
			s[location] = "-";
			
			for(int j=0; j<s.length; j++) {
				if(s[j].equals("-")) continue;
				sb.append(s[j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}