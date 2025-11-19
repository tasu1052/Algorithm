import java.io.*;
import java.util.*;
  
public class Main {
    static int count = 0;
    static long[] dnaCount = new long[4];
    static int[] minimumDNA = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//첫번째 줄 입력 받기
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
//둘째 줄 입력 받기
        String s = br.readLine();
        char[] DNA = new char[S];
        for(int i=0; i<S; i++) DNA[i] = s.charAt(i);
//셋째 줄 입력 받기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) minimumDNA[i] = Integer.parseInt(st.nextToken());
//count 계산
        Deque<Character> q = new LinkedList<>();
        for(int i=0; i<P; i++){
            q.addLast(DNA[i]);
            plusCount(q.peekLast());
        }
        check();
        
        int idx = P;
        while(idx<S){
            minusCount(q.pollFirst());
            q.addLast(DNA[idx]);
            plusCount(q.peekLast());
            check();
            idx++;
        }
        System.out.print(count);
    }
    static void plusCount(char c){
        if(c == 'A') dnaCount[0]++;
        else if(c == 'C') dnaCount[1]++;
        else if(c == 'G') dnaCount[2]++;
        else dnaCount[3]++;
    }
        static void minusCount(char c){
        if(c == 'A') dnaCount[0]--;
        else if(c == 'C') dnaCount[1]--;
        else if(c == 'G') dnaCount[2]--;
        else dnaCount[3]--;
    }
    static void check(){
        boolean checkNum = true;
        for(int i=0; i<4; i++){
            if(dnaCount[i]<minimumDNA[i]) checkNum = false;
        }
        if(checkNum) count++;
    }
}