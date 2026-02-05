import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, C;
	static int[][] map;
	static int[][] profit;
    static int best; // 현재 구간의 최대 sqSum
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	for (int tc = 1; tc <= T; tc++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken()); //전체 벌통 크기
    		M = Integer.parseInt(st.nextToken()); //채취하는 벌통 개수
    		C = Integer.parseInt(st.nextToken()); //채취 최대 양
    		
    		map = new int[N][N]; //전체 꿀통 생성
    		for(int i=0; i<N; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j=0; j<N; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		profit = new int[N][N-M+1];
    		
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<N-M+1; j++) {
    				profit[i][j] = calcProfitRec(i, j);
    			}
    		}
    		
    		int max = 0;
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<N-M+1; j++) {
    				int a = profit[i][j];
    				int sum = 0;
    				
    				for(int n=i; n<N; n++) {
    					for(int m=0; m<N-M+1; m++) {
    						int b = profit[n][m];
    						if(n == i && m < j+M) continue;
    						
    						sum = a + b;
    						max = Math.max(max, sum);
    					}
    				}
    			}
    		}
    		    		
    		
    		sb.append('#').append(tc).append(' ').append(max).append('\n');
    		
        }
    	
    	System.out.print(sb);
    }
    static int calcProfitRec(int r, int c) {
        best = 0;
        subset(r, c, 0, 0, 0);
        return best;
    }

    static void subset(int r, int c, int depth, int sum, int sqSum) {
        if (sum > C) return;          // 가지치기
        if (depth == M) {
            best = Math.max(best, sqSum);
            return;
        }

        int v = map[r][c + depth];

        // 선택
        subset(r, c, depth + 1, sum + v, sqSum + v * v);

        // 미선택
        subset(r, c, depth + 1, sum, sqSum);
    }

}

