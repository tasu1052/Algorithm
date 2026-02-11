import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
       	st = new StringTokenizer(br.readLine());
       	int A = Integer.parseInt(st.nextToken());
       	int B = Integer.parseInt(st.nextToken());
        	
       	int ans = 0;
       	while(A > 0 && B > 0) {
        	
       		A -= 2;
       		if(A<0) break;
        	B--;
        	ans++;
        }
        System.out.println(ans);
        
    }
}