import java.io.*;
import java.util.*;

public class Solution {
    static int[][] wheel;
    static int[] dir; // 각 자석의 회전 방향
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());

            wheel = new int[4][8];

            for (int i = 0; i < 4; i++) { //각 바퀴에 처음 상태 저장
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) wheel[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int k=0; k<K; k++) { // 회전 한 번 하기
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1; // 0-index
                int rotate = Integer.parseInt(st.nextToken()); // 1: 시계, -1: 반시계

                dir = new int[4];
                dir[start] = rotate;
                
                // 왼쪽으로 전파
                spreadLeft(start - 1, start);

                // 오른쪽으로 전파
                spreadRight(start + 1, start);

                // 전파 방향 결정 후 한 번에 회전 적용
                for (int i = 0; i < 4; i++) {
                    if (dir[i] == 1) rotateClock(wheel[i]);
                    else if (dir[i] == -1) rotateCounterClock(wheel[i]);
                }
            }

            int ans = 0;

            for(int i=0; i<4; i++) {
                if(wheel[i][0] == 1) ans += (int) Math.pow(2, i);
            }

            sb.append('#').append(tc).append(' ').append(ans).append('\n');

        }

        System.out.print(sb);
    }
    //cur = 전파되는 대상, right = cur의 오른쪽
    static void spreadLeft(int cur, int right){
        if(cur < 0) return;

        if(wheel[cur][2] != wheel[right][6]){
            dir[cur] = -dir[right];
            spreadLeft(cur - 1, cur);
        }
    }
    //cur = 전파되는 대상, right = cur의 왼쪽
    static  void spreadRight(int cur, int left){
        if(cur >= 4) return;

        if(wheel[left][2] != wheel[cur][6]){
            dir[cur] = -dir[left];
            spreadRight(cur + 1, cur);
        }
    }

    static void rotateCheck(int s, int r) {
        if(s < 0 || s >= 4) return;

        if(wheel[s][6] == wheel[s-1][2]) {
            rotateCheck(s-1, -r);
        }

        if(wheel[s][2] == wheel[s+1][6]) {
            rotateCheck(s+1, -r);
        }
    }

    static void rotateClock(int[] arr) { // 시계 회전
        int last = arr[7];
        for (int i = 7; i > 0; i--) arr[i] = arr[i - 1];
        arr[0] = last;
    }

    static void rotateCounterClock(int[] arr) { // 반시계 회전
        int first = arr[0];
        for (int i = 0; i < 7; i++) arr[i] = arr[i + 1];
        arr[7] = first;
    }

}