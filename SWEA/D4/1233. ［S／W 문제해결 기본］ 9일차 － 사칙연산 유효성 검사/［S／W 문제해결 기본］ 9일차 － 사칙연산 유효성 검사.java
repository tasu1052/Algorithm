import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T = 10;
        
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            String[] tree= new String[N+1];
            
            for(int i=1; i<=N; i++) {
            	String[] s = br.readLine().split(" ");
            	tree[i] = s[1];
            }
            
            boolean check = true;
            for(int i=1; i<=N/2; i++) {
            	if(!tree[i].equals("+") && !tree[i].equals("-")
            	&& !tree[i].equals("*") && !tree[i].equals("/")) {
            		check = false;
            		break;
            	}
            }
            
            for(int i=N/2+1; i<=N; i++) {
            	if(tree[i].equals("+") && tree[i].equals("-")
            	&& tree[i].equals("*") && tree[i].equals("/")) {
            		check = false;
            		break;
            	}
            }
            
            
            if(check) sb.append("#").append(t).append(" ").append(1).append('\n');
            else sb.append("#").append(t).append(" ").append(0).append('\n');
        }
        System.out.print(sb);
    }
}