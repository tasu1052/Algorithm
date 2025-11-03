import java.io.*;
import java.util.*;
     
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
             
        for(int t=1; t<=T; t++){
            List<String> list = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int index = 0;
            while(st.hasMoreTokens()){
                list.add(index, st.nextToken());
                index++;
            }

            int num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String cmd = st.nextToken();
                if(cmd.equals("I")){
                    int idx = Integer.parseInt(st.nextToken());
                    int cnt = Integer.parseInt(st.nextToken());
                    for(int i=0; i<cnt; i++){
                        list.add(idx++, st.nextToken());
                    }
                }
                else if(cmd.equals("D")){
                    int idx = Integer.parseInt(st.nextToken());
                    int cnt = Integer.parseInt(st.nextToken());
                    for(int i=0; i<cnt; i++){
                        list.remove(idx);
                    }
                }
                else if(cmd.equals("A")){
                    int cnt = Integer.parseInt(st.nextToken());
                    for(int i=0; i<cnt; i++){
                        list.add(st.nextToken());
                    }
                }
            }

            sb.append("#").append(t).append(" ");
            for(int i=0; i<10; i++){
                sb.append(list.get(i)).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}