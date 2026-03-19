import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static boolean[] isBot;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] belt = new int[N * 2];   
        isBot = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N*2; i++) belt[i] = Integer.parseInt(st.nextToken());
        
        int level = 0;
        while(true) {
        	rotate(belt); //1.벨트와 각 칸의 로봇 한 칸씩 회전
        	if(isBot[N-1]) isBot[N-1] = false; //이때 로봇이 N-1 도달하면 바로 내리기
        	
        	move(belt); //2.가장 먼저 올라간 로봇부터 한 칸씩 이동, 이동 안되면 가만히
        	
        	if(belt[0] > 0 && !isBot[0]) { //3.올리는 칸 내구도 0 아니면 로봇 올리기
        		isBot[0] = true;
        		belt[0]--;
        	}
        	
        	level++; //레벨 횟수 올리기
        	
        	if(checkStop(belt)) break; //4.내구도 0인 칸 K개 이상이면 break;
        		
        }

        System.out.print(level);
    }
    static void rotate(int[] arr) {
    	int tmp = arr[arr.length - 1];
    	
    	for(int i=arr.length-1; i>0; i--) { //벨트 한 칸 씩 뒤로 밀기
    		arr[i] = arr[i-1];
    	}
    	
    	arr[0] = tmp; //처음 자리에 벨트 올라옴
    	
    	for(int i=N-2; i>=0; i--) { //로봇도 벨트에 맞춰 한칸씩 밀림
    		if(isBot[i]) {
    			isBot[i+1] = true;
    			isBot[i] = false;
    		}
    	}
    	
    }
    static void move(int[] arr) { //로봇은 처음 올라온거부터 이동
    	for(int i=N-2; i>=0; i--) {
    		if(isBot[i]) { //로봇이 있고
    			if(!isBot[i+1] && arr[i+1] > 0) { //다음 자리에 로봇이 없으면서 벨트 내구도 1이상이면
    				isBot[i] = false; //로봇 이동 시키기
    				isBot[i+1] = true;
    				arr[i+1]--;
    			}
    		}
    	}
    }
    static boolean checkStop(int[] arr) { //종료 조건 검사
    	int cnt = 0;
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i] == 0) cnt++;
    		
    	}
    	if(cnt >= K) return true;
    	return false;
    }
}
