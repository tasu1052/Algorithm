import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] button;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N =  Integer.parseInt(br.readLine()); // 스위치 개수 입력
        button = new int[N+1]; // 스위치 배열 선언

        st = new StringTokenizer(br.readLine()); // 스위치 정보 입력
        for(int i=1; i<=N; i++) button[i] = Integer.parseInt(st.nextToken());

        int stuNum = Integer.parseInt(br.readLine()); // 학생 수 입력
        for(int i=0; i<stuNum; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(gender == 1){ //남자인 경우
                boy(button, num);
            } else{ //여자인 경우
                girl(button, num);
            }
        }

        for(int i=1; i<button.length; i++){
            sb.append(button[i]).append(" ");
            if(i % 20 == 0) sb.append('\n');
        }

        System.out.print(sb);
    }

    static void boy(int[] button, int num){
        for(int i=num; i<button.length; i += num){
            if(button[i] == 1) button[i] = 0;
            else button[i] = 1;
        }
    }

    static void girl(int[] button, int num){
        for(int i=num, j=num; i<button.length && j>0; i++, j--){
            if(button[i] == button[j]) {
                if (button[i] == 1 && button[j] == 1) {
                    button[i] = 0; button[j] = 0;
                }
                else if(button[i] == 0 && button[j] == 0){
                    button[i] = 1;  button[j] = 1;
                }
            } else break;
        }
    }
}