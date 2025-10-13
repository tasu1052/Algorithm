import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int t=1; t<=T; t++) {
            String s = br.readLine();
            int answer = 0;

            for (int i=1; i<=10; i++) {
                String pattern = s.substring(0, i); 
                StringBuilder repeated = new StringBuilder();
                
                while (repeated.length() < 30) {
                    repeated.append(pattern);
                }
                
                if (s.equals(repeated.substring(0, 30))) {
                    answer = i;
                    break;
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append('\n');
        }

        System.out.print(sb);
    }
}
