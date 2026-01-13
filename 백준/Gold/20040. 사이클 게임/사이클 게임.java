import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	int cnt = 0;
public static void main(String args[]) throws IOException
{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st;
	 
	 st = new StringTokenizer(br.readLine());
	 int n = Integer.parseInt(st.nextToken());
	 int m = Integer.parseInt(st.nextToken());
	 
	 parent = new int[n];
	 for(int i=0; i<n; i++) parent[i] = i;
	 
	 int cnt = 0;
	 for(int i=1; i<=m; i++) {
		 st = new StringTokenizer(br.readLine());
		 int a = Integer.parseInt(st.nextToken());
		 int b = Integer.parseInt(st.nextToken());
		 
		 if(find(a) == find(b)) {
			 System.out.println(i);
			 return;
		 }
		 union(a, b);
	 }
	 
	 System.out.println(0);
}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a > b) parent[a] = b;
		else parent[b] = a;
	}
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
}