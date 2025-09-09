import java.io.*;
import java.util.*;

public class Main{
    static int K = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        K = (int)(Math.pow(2, N) - 1);
        System.out.println(K);
        
        hanoi(N, 1, 3, 2);
        
        System.out.print(sb);
    }
    
    static void hanoi(int N, int from, int to, int via){
        if(N==1){
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        
        hanoi(N-1, from, via ,to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(N-1, via, to, from);
    }
}