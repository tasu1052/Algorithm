import java.io.*;
import java.util.*;

public class Main {
	static int N, M, Z;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] map;
	static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //N개의 필드
        Z = Integer.parseInt(st.nextToken()); //도착해야하는 필드 번호 Z
        M = Integer.parseInt(st.nextToken()); //M개의 장애물
        
        boolean[] arr = new boolean[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
        	int num = Integer.parseInt(st.nextToken()); //1 - index
        	arr[num] = true; //장애물 있는 곳 true 처리
        }
        
        int level = 1;
        int idx = 1;
        
        boolean[] visited = new boolean[N+1];
        
        while(true) {
        	idx += level; //인덱스 값 증가시키면서 검사 시작
        	
        	
        	if(idx > N) idx %= N; //N의 범위 넘어가면 0으로
        	
        	if(visited[idx]) {
        		visited = new boolean[N+1];
        		idx = 1; //다시 시작 인덱스 초기화하고
        		level++; //다음 레벨 검사하기 위해 레벨 하나 증가
        		continue;
        	}
        	visited[idx] = true;
        	
        	if(arr[idx]) { //장애물 밟으면 그 레벨은 안되는 것
        		//혹은 그곳을 그 레벨에서 이미 방문했다면 의미없음
        		visited = new boolean[N+1];
        		idx = 1; //다시 시작 인덱스 초기화하고
        		level++; //다음 레벨 검사하기 위해 레벨 하나 증가
        		continue;
        	}
        	
        	if(idx == Z) break; //맞는 레벨 도달 시 검사 종료
        }

        System.out.print(level);//1 3 5 7 9 1 3 5 7 9
    }
}
