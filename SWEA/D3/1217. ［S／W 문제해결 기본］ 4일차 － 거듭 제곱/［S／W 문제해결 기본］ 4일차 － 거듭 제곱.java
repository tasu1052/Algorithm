import java.util.Scanner;
    
public class Solution {
    public static void main(String[] args){
        int T = 10;
        Scanner sc = new Scanner(System.in);
        
        for(int t=1; t<=T; t++){
            int tc = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int num = 1;

            for(int i=1; i<=b; i++){
                num *= a;
            }

            System.out.println("#" + tc + " " + num);
        }
    }
}