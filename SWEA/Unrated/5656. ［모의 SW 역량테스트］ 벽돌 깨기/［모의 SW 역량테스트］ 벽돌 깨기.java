import java.io.*;
import java.util.*;

public class Solution {
	static int N, W, H;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = Integer.MAX_VALUE;
			

			for(int i=0; i<W; i++) {
				int[][] tmp = new int[H][W];
				for(int j=0; j<H; j++) tmp[j] = map[j].clone();
					
				fallBrick(i, tmp, 0);
			}
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
	static void fallBrick(int idx, int[][] arr, int num) {
		if(num == N) {
			int cnt = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(arr[i][j] != 0) cnt++;
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		
		int heightIdx = -1;
		for(int i=0; i<H; i++) {
			if(arr[i][idx] != 0) {
				heightIdx = i;
				break;
			}
		}
		
		if(heightIdx == -1) {
			for(int i=0; i<W; i++) {
				if(i == idx) continue;
				int[][] tmp = new int[H][W];
			    for(int j=0; j<H; j++) tmp[j] = arr[j].clone();
				fallBrick(i, tmp, num + 1);
			}
			return;
		}
		
		propagation(heightIdx, idx, arr, arr[heightIdx][idx]);
		
		for(int i=0; i<W; i++) gravity(i, arr);
		
		for(int i=0; i<W; i++) {
			int[][] tmp = new int[H][W];
		    for(int j=0; j<H; j++) tmp[j] = arr[j].clone();
			fallBrick(i, tmp, num + 1);
		}
		
	}
	static void propagation(int x, int y, int[][] arr, int num) {
		for(int i=x-num+1; i<x+num; i++) {
			if(i < 0 || i >= H) continue;
			
			if(arr[i][y] == 1) arr[i][y] = 0;
			else {
				int tmpNum = arr[i][y];
				arr[i][y] = 0;
				propagation(i, y, arr, tmpNum);
			}
		}
		for(int i=y-num+1; i<y+num; i++) {
			if(i < 0 || i >= W) continue;
			
			if(arr[x][i] == 1) arr[x][i] = 0;
			else {
				int tmpNum = arr[x][i];
				arr[x][i] = 0;
				propagation(x, i, arr, tmpNum);
			}
		}
	}
	static void gravity(int idx, int[][] arr) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		for(int i=H-1; i>=0; i--) {
			if(arr[i][idx] != 0) {
				q.add(arr[i][idx]);
				arr[i][idx] = 0;
			}
		}
		
		for(int i=H-1; i>=0; i--) {
			if(q.isEmpty()) break;
			arr[i][idx] = q.poll();
		}
	}
}
