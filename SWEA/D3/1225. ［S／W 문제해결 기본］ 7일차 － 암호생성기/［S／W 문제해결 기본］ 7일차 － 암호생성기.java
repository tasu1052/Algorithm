import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        //int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= 10; t++) {
        	int T = Integer.parseInt(br.readLine());
        	Deque<Integer> q = new ArrayDeque<>();
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<8; i++) q.add(Integer.parseInt(st.nextToken()));
        	
        	int num = 1;
        	while(true) {
        		int tmp = q.pollFirst() - num;
        		if(tmp <= 0) {
        			tmp = 0;
        			q.addLast(tmp);
        			break;
        		}
        		q.addLast(tmp);
        		
        		num++;
        		
        		if(num > 5) num = 1;
        	}
        	
        	sb.append("#").append(t).append(" ");
        	while(!q.isEmpty()) sb.append(q.pollFirst() + " ");
        	sb.append('\n');
        }
        System.out.print(sb);
	}

}
