import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = s.charAt(j-1);
			}
		}
		
		char start = map[1][1];
		
		int[][] arrB = new int[N+1][M+1];
		int[][] arrW = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
		    for(int j = 1; j <= M; j++) {

		        // B 시작 기준
		        if ((i + j) % 2 == 0)
		            arrB[i][j] = (map[i][j] == 'B') ? 0 : 1;
		        else
		            arrB[i][j] = (map[i][j] == 'W') ? 0 : 1;

		        // W 시작 기준
		        if ((i + j) % 2 == 0)
		            arrW[i][j] = (map[i][j] == 'W') ? 0 : 1;
		        else
		            arrW[i][j] = (map[i][j] == 'B') ? 0 : 1;
		    }
		}
		
		int[][] psB = new int[N+1][M+1];
		int[][] psW = new int[N+1][M+1];
		
		int min = Integer.MAX_VALUE;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				psB[i][j] = psB[i-1][j] + psB[i][j-1] - psB[i-1][j-1] + arrB[i][j];
				psW[i][j] = psW[i-1][j] + psW[i][j-1] - psW[i-1][j-1] + arrW[i][j];
			}
		}
		
		for(int i=K; i<=N; i++) {
			for(int j=K; j<=M; j++) {
				int repaintB =
			              psB[i][j]
			            - psB[i-K][j]
			            - psB[i][j-K]
			            + psB[i-K][j-K];
				
				int repaintW =
			              psW[i][j]
			            - psW[i-K][j]
			            - psW[i][j-K]
			            + psW[i-K][j-K];
				
				min = Math.min(min, Math.min(repaintB, repaintW));
			}
		}
		System.out.println(min);
	}
}
