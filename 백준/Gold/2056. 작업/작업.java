import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] A;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        int[] degree = new int[N+1];
        int[] time = new int[N+1];
        int[] result = new int[N+1];
        
        A = new ArrayList[N+1];
        for(int i=0; i<=N; i++) A[i] = new ArrayList<>();
        
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	time[i] = Integer.parseInt(st.nextToken());
        	int cnt = Integer.parseInt(st.nextToken());
        	
        	for(int j=0; j<cnt; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		A[num].add(i);
        		degree[i]++;
        	}
        }
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for(int i=1; i<=N; i++) {
        	result[i] = time[i];
        	if(degree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()) {
        	int now = q.poll();
        	
        	for(int next : A[now]) {
        		result[next] = Math.max(result[next], result[now] + time[next]);
        		degree[next]--;
        		if(degree[next] == 0) {
        			q.add(next);
        		}
        	}
        }
        
        int ans = 0;
        for(int i=1; i<=N; i++) ans = Math.max(ans, result[i]);
        
        System.out.println(ans);
    }
}