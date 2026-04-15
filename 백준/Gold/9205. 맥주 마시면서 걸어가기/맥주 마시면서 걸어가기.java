import java.io.*;
import java.util.*;

public class Main {
	static int endX, endY;
	static Pos[] convArr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int conv = Integer.parseInt(br.readLine());
			
			convArr = new Pos[conv];

			
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<conv; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				convArr[i] = new Pos(x, y);
			}
			
			
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			if(bfs(startX, startY)) sb.append("happy").append('\n');
			else sb.append("sad").append('\n');
			
		}
		System.out.println(sb);
	}
	static boolean bfs(int sx, int sy) {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		boolean[] visited = new boolean[convArr.length];
		
		q.add(new Pos(sx, sy));
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			if(cal(cur.x, cur.y, endX, endY) <= 1000) return true;
			
			for(int i=0; i<convArr.length; i++) {
				if(!visited[i] && cal(cur.x, cur.y, convArr[i].x, convArr[i].y) <= 1000) {
					visited[i] = true;
					q.add(convArr[i]);
				}
			}
		}
		return false;
	}
	static int cal(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
class Pos{
	int x, y;
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}
