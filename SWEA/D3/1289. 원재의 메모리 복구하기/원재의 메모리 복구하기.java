import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            String line = br.readLine();
            int cnt = 0;
            int[] ans = new int[line.length()];
            for(int i=0; i<ans.length; i++) ans[i] = line.charAt(i) - '0';
             
            int[] arr = new int[ans.length];
             
            for(int i=0; i<ans.length; i++) {
                if(arr[i] == ans[i]) continue;
                 
                for(int j=i; j<ans.length; j++) {
                    if(arr[j] == 0) arr[j] = 1;
                    else arr[j] = 0;
                }
                cnt++;
            }
             
             
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
	}
}
