import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static long ans;
	static int[] arr;
    public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            
            arr = new int[N];
            ans = 0;
            
            for(int i=0; i<N; i++) arr[i] = sc.nextInt();
            
            boolean[] peak = new boolean[N];
            for(int i=1; i<N-1; i++) {
            	if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) peak[i] = true;
            }
            
            for(int i=1; i<N-1; i++) {
            	long sum = 0;
            	if(peak[i]) {
            		sum += up(i) * down(i);
            	}
            	ans += sum;
            }

            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }
        System.out.println(sb);
    }
    static long up(int idx) {  	
    	long cnt = 0;
    	
    	for(int i=idx; i>=1; i--) {
    		if(arr[i-1] < arr[i]) cnt++;
    		else break;
    	}
    	
    	return cnt;
    }
    
    static long down(int idx) {
    	long cnt = 0;
    	
    	for(int i=idx; i<N-1; i++) {
    		if(arr[i] > arr[i+1]) cnt++;
    		else break;
    	}
    	
    	return cnt;
    }
}
