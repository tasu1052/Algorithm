import java.io.*;
import java.util.*;

public class Main {
	static char[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		int num = (int) Math.pow(5, N);
		arr = new char[num][num];
		for (int i = 0; i < num; i++) Arrays.fill(arr[i], ' ');
		
		if(N == 0) {
			System.out.println("*");
			return;
		} else {
			star(num/2, num/2, N);
		}
		
		for(char[] ch : arr) {
			for(char c : ch) sb.append(c);
			sb.append('\n');
		}
		System.out.println(sb);
	}
	static void star(int x, int y, int depth) {
		int n = (int) Math.pow(5, depth - 1);
		if(depth == 1) {
			arr[x-2][y] = '*';
			arr[x-1][y] = '*';
			arr[x][y-2] = '*'; arr[x][y-1] = '*'; arr[x][y] = '*'; arr[x][y+1] = '*'; arr[x][y+2] = '*';
			arr[x+1][y-1] = '*'; arr[x+1][y] = '*'; arr[x+1][y+1] = '*';
			arr[x+2][y-1] = '*'; arr[x+2][y+1] = '*';
		} else {
			star(x-2*n, y, depth - 1);
			star(x-n, y, depth - 1);
			star(x, y-2*n, depth -1); star(x,y-n, depth -1); star(x, y, depth -1); star(x, y+n, depth -1); star(x, y+2*n, depth -1);
			star(x+n, y-n , depth -1); star(x+n, y , depth -1); star(x+n, y+n , depth -1);
			star(x+2*n, y-n , depth -1); star(x+2*n, y+n , depth -1);
		}
	}
}