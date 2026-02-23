import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		LocalDate now = LocalDate.now();
		
		String[] s = String.valueOf(now).split("-");
		
		for(int i=0; i<3; i++) sb.append(s[i]).append('\n');
		
		System.out.println(sb);
	}
}
