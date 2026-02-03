import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[100][100];
        boolean[][] visited = new boolean[100][100];
        
        for(int t=0; t<N; t++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	for(int i=x; i<x+10; i++) {
        		for(int j=y; j<y+10; j++) {
        			map[i][j] = 1;
        		}
        	}
        }
        
//        for(int[] a : map) {
//        	for(int b : a) {
//        		System.out.print(b);
//        	}
//        	System.out.println();
//        }
        
        int ans = 0;
        for(int i=0; i<100; i++) {
        	for(int j=0; j<100; j++) {
        		if(map[i][j] == 1) {
        			for(int k=0; k<4; k++) {
        				int x = i + dx[k];
        				int y = j + dy[k];
        				
        				if(x < 0 || x >= 100 || y < 0 || y >= 100) {
                            ans++;
                        } else if(map[x][y] == 0) {
                            ans++;
                        }
        			}
        		}
        	}
        }
        
        System.out.println(ans);
        
	}

}