import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int index = -1;
        int sum = 0;

        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(c=='*'){
                index = i;
                continue;
            }
            int digit = c - '0';
            if(i%2==0) sum += digit;
            else sum += digit*3;
        }
        
        int missing;
        if(index%2==0)
            missing = (10-(sum%10))%10;
        else
            missing = ((10-(sum%10))*7)%10;

        System.out.print(missing);
    }
}