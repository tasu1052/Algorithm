import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] count = new int[N+1];
        char[] num = new char[]{'3', '6', '9'};

        for(int i=1; i<=N; i++){
            String S = Integer.toString(i);

            for(int j=0; j<S.length(); j++){
                for(int k=0; k<3; k++){
                    if(S.charAt(j) == num[k]) count[i]++;
                }
            }
        }

        for(int i=1; i<=N; i++){
            if(count[i]==0)
                sb.append(i).append(" ");
            else{
                for(int j=0; j<count[i]; j++){
                    sb.append("-");
                }
                sb.append(" ");
            }
        }
        
        System.out.print(sb);
    }
}