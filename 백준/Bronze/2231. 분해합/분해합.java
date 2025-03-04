import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int N = Integer.parseInt(br.readLine());
        int start = Math.max(1, N-(String.valueOf(N).length()*9));
        for(int i=start; i<N; i++){
            int num=i;
            int part =0;
            
            while(num>0){//각 자리수 더하기
                part+=num%10;
                num/=10;
            }
            
            int sum=i+part;
            
            if(sum==N){ //생성자 + 각 자리수 합이 N이면 생성자 출력 후 종료
                System.out.print(i);
                return;
            }
        }
        System.out.print(0); //생성자 없으면 0 출력
    }
}