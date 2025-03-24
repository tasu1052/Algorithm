import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        String[][] S = new String[N][2];
        StringTokenizer st;
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            S[i][0] = st.nextToken();
            S[i][1] = st.nextToken();
        }
        
        Arrays.sort(S, (s1, s2)->{
            if(Integer.parseInt(s1[0])==
               Integer.parseInt(s2[0])){
                return 0;
            }
            else{
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });
        
        for(int i=0; i<S.length; i++){
            sb.append(S[i][0] + " " + S[i][1]).append('\n');
        }
        
        System.out.print(sb);
        
    }
}