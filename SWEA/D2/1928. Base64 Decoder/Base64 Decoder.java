import java.io.*;
import java.util.*;

public class Solution {
    static int[] num = new int[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
   
        for(int i=1; i<=T; i++){
            String S = br.readLine();
            StringBuilder result = new StringBuilder();

            for(int j=0; j<S.length(); j+=4){
                int n1 = Encoding(S.charAt(j));
                int n2 = Encoding(S.charAt(j + 1));
                int n3 = Encoding(S.charAt(j + 2));
                int n4 = Encoding(S.charAt(j + 3));

                int combined = (n1<<18) | (n2<<12) | (n3<<6) | n4;

                result.append((char) ((combined >> 16) & 0xFF));
                result.append((char) ((combined >> 8) & 0xFF));
                result.append((char) (combined & 0xFF));
            }
            sb.append("#").append(i).append(" ").append(result).append('\n');
        }
        System.out.print(sb);
    }

    public static int Encoding(char c){
        if('A'<=c&&c<='Z') return c-'A';
        else if('a'<=c&&c<='z') return c-'a'+26;
        else if('0'<=c&&c<='9') return c-'0'+52;
        else if(c=='+') return 62;
        else if(c=='/') return 63;
        else return 0;
    }
}