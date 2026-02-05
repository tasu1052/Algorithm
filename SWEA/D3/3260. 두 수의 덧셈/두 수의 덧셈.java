import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	String a = st.nextToken();
        	String b = st.nextToken();
        	
        	BigInteger A = new BigInteger(a);
        	BigInteger B = new BigInteger(b);
        	
        	
        	sb.append("#").append(t).append(" ").append(A.add(B)).append('\n');
        }
        System.out.print(sb);
	}
}
