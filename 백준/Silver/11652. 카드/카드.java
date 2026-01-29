import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		TreeMap<Long, Integer> hm = new TreeMap<>();
		
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}
		int max = 0;
		for(Map.Entry<Long, Integer> entry : hm.entrySet()) {
			if(entry.getValue() > max) max = entry.getValue();
		}
		
		for(Map.Entry<Long, Integer> entry : hm.entrySet()) {
			if(entry.getValue() == max) {
				System.out.println(entry.getKey());
				break;
			}
		}
	}
}