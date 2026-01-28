import java.io.*;
import java.util.*;

public class Main {
	static int[][] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		tree = new int[N][2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int Node = st.nextToken().charAt(0) - 'A';
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			if(left == '.') tree[Node][0] = -1;
			else tree[Node][0] = left - 'A';
			
			if(right == '.') tree[Node][1] = -1;
			else tree[Node][1] = right - 'A';
		}
		
		preOrder(0);
		sb.append('\n');
		inOrder(0);
		sb.append('\n');
		postOrder(0);
		System.out.println(sb);
	}
	static void preOrder(int num) {
		if(num == -1) {
			return;
		}
		sb.append((char) (num + 'A'));
		preOrder(tree[num][0]);
		preOrder(tree[num][1]);
	}
	static void inOrder(int num) {
		if(num == -1) {
			return;
		}
		inOrder(tree[num][0]);
		sb.append((char) (num + 'A'));
		inOrder(tree[num][1]);
	}
	static void postOrder(int num) {
		if(num == -1) {
			return;
		}
		postOrder(tree[num][0]);
		postOrder(tree[num][1]);
		sb.append((char) (num + 'A'));
	}
}
