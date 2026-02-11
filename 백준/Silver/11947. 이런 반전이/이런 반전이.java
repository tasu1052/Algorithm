import java.io.*;
import java.util.*;

public class Main {
	static long value(long x, long all9) {
		return x * (all9 - x);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
        	Long N = Long.parseLong(br.readLine());
        	
        	long max = 0;
        	
        	int d = Long.toString(N).length();
        	
        	long pow10 = 1;
        	
        	for(int i=1; i<=d; i++) {
        		pow10 *= 10;
        		long all9 = pow10 - 1;
        		
        		long mid = all9 / 2;
        		
        		if(i < d) {
        			max = Math.max(max, value(mid, all9));
        			max = Math.max(max, value(mid + 1, all9));
        		} else {
        			if(N <= mid) {
        				max = Math.max(max, value(N, all9));
        			} else {
        				max = Math.max(max, value(mid, all9));
        				max = Math.max(max, value(mid + 1, all9));
        			}
        		}
        	}
        	
        	sb.append(max).append('\n');
        }
        System.out.println(sb);
        
    }
}