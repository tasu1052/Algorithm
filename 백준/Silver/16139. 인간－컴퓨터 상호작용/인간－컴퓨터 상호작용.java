import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] arr = new int[s.length()+1][26];

        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<26; j++){
                arr[i][j] = arr[i-1][j];
            }
            arr[i][s.charAt(i-1) - 'a']++;
        }

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            char keyWord = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(arr[end + 1][keyWord - 'a'] 
                      - arr[start][keyWord - 'a']).append('\n');
        }
        System.out.print(sb);
    }
}