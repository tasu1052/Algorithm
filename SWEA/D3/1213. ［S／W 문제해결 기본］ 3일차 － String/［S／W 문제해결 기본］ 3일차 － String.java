import java.io.*;
import java.util.*;
    
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
            
        for(int t=1; t<=T; t++){
            int tc = Integer.parseInt(br.readLine());
            String S = br.readLine();
            char[] search = new char[S.length()];

            for(int i=0; i<S.length(); i++){
                search[i] = S.charAt(i);
            }

            String find = br.readLine();
            char[] arr = new char[find.length()];

            for(int i=0; i<find.length(); i++){
                arr[i] = find.charAt(i);
            }

            int count = 0;
            
            for(int i=0; i<=arr.length-search.length; i++){
                if(arr[i] == search[0]){
                    boolean check = true;

                    for(int j=0; j<search.length; j++){
                        if(arr[i+j] != search[j]){
                            check = false;
                            break;
                        }
                    }
                    if(check) count++;
                }
            }
            sb.append("#").append(tc).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
    }
}