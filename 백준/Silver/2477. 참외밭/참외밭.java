import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		Line[] arr = new Line[6];
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			arr[i] = new Line(dir, len);
		}
		
		int maxH = 0, maxV = 0;
		int maxHIdx = 0, maxVIdx = 0;

		// 최대 가로/세로 + 인덱스 찾기
		for(int i=0; i<6; i++) {
		    if(arr[i].dir == 1 || arr[i].dir == 2) {
		        if(arr[i].len > maxH) {
		            maxH = arr[i].len;
		            maxHIdx = i;
		        }
		    } else {
		        if(arr[i].len > maxV) {
		            maxV = arr[i].len;
		            maxVIdx = i;
		        }
		    }
		}

		int sum = maxH * maxV;

		// 작은 사각형
		int smallH = Math.abs(arr[(maxHIdx + 3) % 6].len);
		int smallV = Math.abs(arr[(maxVIdx + 3) % 6].len);

		int hole = smallH * smallV;
		
		System.out.println((sum - hole) * K);
	}
}
class Line{
	int dir;
	int len;
	
	Line(int dir, int len){
		this.dir = dir;
		this.len = len;
	}
}
