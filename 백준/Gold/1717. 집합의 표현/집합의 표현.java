import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parent = new int[N+1];
        for(int i=0; i<=N; i++) parent[i] = i;
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int com = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if(com == 0) union(a, b);
        	else {
        		if(find(a) == find(b)) sb.append("YES").append('\n');
        		else sb.append("NO").append('\n');
        	}
        }
        
        System.out.println(sb);
    }
    static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	
    	if(a != b) parent[b] = a;
    }
    static int find(int x) {
    	if(x == parent[x]) return x;
    	return parent[x] = find(parent[x]);
    }
}