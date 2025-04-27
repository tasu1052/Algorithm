import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            char[] c = new char[S.length()];
            for(int j=0; j<S.length(); j++){
                c[j] = S.charAt(j);
            }
            sb.append(isPalindrome(c)).append(" ").append(cnt).append('\n');
            cnt = 0;
        }
        System.out.print(sb);
    }
    static int isPalindrome(char[] s){
        return recursion(s, 0, s.length - 1);
    }
    static int recursion(char[] s, int l, int r){
        if(l>=r){ 
            cnt++;
            return 1;
        }
        else if(s[l]!=s[r]){
            cnt++;
            return 0;
        }
        else{
            cnt++;
            return recursion(s, l+1, r-1);
        }
    }
}