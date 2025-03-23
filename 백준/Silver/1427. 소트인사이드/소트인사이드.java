import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String N = br.readLine();
        
        int[] cnt = new int[10];
        
        for(int i=0; i<N.length(); i++){
            char c = N.charAt(i);
            cnt[c - '0']++;
        }
        
        for(int i=9; i>=0; i--){
            while(cnt[i]>0){
                sb.append(i);
                cnt[i]--;
            }
        }
        
        System.out.print(sb);
        
    }
}