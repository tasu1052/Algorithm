import java.io.*;
import java.util.*;

public class Main{  
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            String com = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());

            if(com.equals("add")) hs.add(num);
            else if(com.equals("remove")) hs.remove(num);
            else if(com.equals("check")){
                if(hs.contains(num)) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
            else if(com.equals("toggle")){
                if(hs.contains(num)) hs.remove(num);
                else hs.add(num);
                }
            else if(com.equals("all")){
                for(int j=1; j<=20; j++) hs.add(j);
            }
            else if(com.equals("empty")) hs.clear();
        }
        System.out.print(sb);
    }
}