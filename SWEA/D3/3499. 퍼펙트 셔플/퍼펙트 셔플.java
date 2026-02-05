import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	String[] arr = br.readLine().split(" ");
        	
        	Queue<String> firstQ = new ArrayDeque<>();
        	Queue<String> secondQ = new ArrayDeque<>();
             
        	if(N % 2 == 1) {
        		for(int i=0; i<N/2 + 1; i++) firstQ.add(arr[i]);
        		for(int i=N/2 + 1; i<N; i++) secondQ.add(arr[i]);
        	}
        	else {
        		for(int i=0; i<N/2; i++) firstQ.add(arr[i]);
        		for(int i=N/2; i<N; i++) secondQ.add(arr[i]);
        	}
            
            sb.append("#").append(t).append(" ");
            
            while(!firstQ.isEmpty() || !secondQ.isEmpty()) {
            	if(!firstQ.isEmpty()) sb.append(firstQ.poll() + " ");
            	if(!secondQ.isEmpty()) sb.append(secondQ.poll() + " ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
	}
}
