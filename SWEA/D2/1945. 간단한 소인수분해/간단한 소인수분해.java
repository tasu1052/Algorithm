import java.io.*;
import java.util.*;

public class Solution {
    static int[] num = new int[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
   
        for(int i=0; i<T; i++){
            int num = Integer.parseInt(br.readLine());
            int counta = 0;
            int countb = 0;
            int countc = 0;
            int countd = 0;
            int counte = 0;
            
            while(num >= 1){
                if(num%2==0){
                    num = num / 2;
                    counta++;
                }
                else if(num%3==0){
                    num = num / 3;
                    countb++;
                }
                else if(num%5==0){
                    num = num / 5;
                    countc++;
                }
                else if(num%7==0){
                    num = num / 7;
                    countd++;
                }
                else if(num%11==0){
                    num = num / 11;
                    counte++;
                }

                if(num==1){
                    sb.append("#").append(i+1).append(" ").append(counta)
                        .append(" ").append(countb).append(" ").append(countc)
                        .append(" ").append(countd).append(" ")
                        .append(counte).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
    } 
}