import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=T; i++){
            String S = br.readLine();
            String year = S.substring(0, 4);
            int month = Integer.parseInt(S.substring(4, 6));
            int day = Integer.parseInt(S.substring(6, 8));

            if(month<1 || month >12){
                sb.append("#").append(i).append(" ").append(-1)
                    .append('\n');
                continue;
            }
            if(month==1 || month==3 || month==5 || month==7 ||
              month==8 || month==10 || month==12){
                if(day<1 || day>31){
                    sb.append("#").append(i).append(" ").append(-1)
                        .append('\n');
                    continue;
                }
            }
            if(month==4 || month==6 || month==9 || month==11){
                if(day<1 || day>30){
                    sb.append("#").append(i).append(" ").append(-1)
                        .append('\n');
                    continue;
                }
            }
            if(month==2){
                if(day<1 || day>28){
                    sb.append("#").append(i).append(" ").append(-1)
                        .append('\n');
                    continue;
                }
            }
            sb.append("#").append(i).append(" ").append(year).append("/")
                    .append(String.format("%02d", month)).append("/").append(String.format("%02d", day)).append('\n');
        }
        System.out.print(sb);
    }
}