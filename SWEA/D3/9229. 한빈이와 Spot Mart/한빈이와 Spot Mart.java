import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static long best;
	static int[] weight;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken()); //과자 수
        	M = Integer.parseInt(st.nextToken()); //무게 합 제한
        	
        	best = -1; //정답값 - 두 과자를 들고 갈 방법 없는 경우 -1 출력
        	weight = new int[N]; //각 과자 별 무게 저장 배열
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<N; i++) weight[i] = Integer.parseInt(st.nextToken());
        	
        	comb(0, 0, 0);
        	
        	sb.append("#").append(tc).append(" ").append(best).append('\n');
        }
        System.out.println(sb);
	}
	
	static void comb(int start, int cnt, long w) {
		if(w > M) return; //제한 무게 보다 높으면 가지치기
		
		if(cnt == 2) {
			best = Math.max(best, w); //과자 2개 뽑았을 때 best 보다 크면 최대값 갱신하기
			return;
		}
		
		for(int i=start; i<N; i++) {
			comb(i + 1, cnt+1, w + weight[i]); //두개를 뽑는 조합의 수
		}
	}

}
