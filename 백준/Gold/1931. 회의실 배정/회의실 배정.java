import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Conference> q = new PriorityQueue<>((a, b) -> {
        	if(a.end == b.end) return Integer.compare(a.start, b.start);
        	return Integer.compare(a.end, b.end);
        });
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	
        	q.add(new Conference(s, e));
        }
        int cnt = 0;
        while(!q.isEmpty()) {
        	Conference now = q.poll();
        	cnt++;
        	
        	while(!q.isEmpty() && now.end > q.peek().start) q.poll();
        }
        
        System.out.println(cnt);
    }
}
class Conference{
	int start;
	int end;
	
	Conference(int start, int end){
		this.start = start;
		this.end = end;
	}
}
