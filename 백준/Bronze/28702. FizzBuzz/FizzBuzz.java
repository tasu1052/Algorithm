import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        int sum = getnum(first, second, third);
        if(sum % 3 == 0 && sum % 5 == 0)
            sb.append("FizzBuzz");
        else if(sum % 3 == 0)
            sb.append("Fizz");
        else if(sum % 5 == 0)
            sb.append("Buzz");
        else sb.append(sum);
                
        System.out.print(sb);
    }
    public static int getnum(String f, String s, String t){
        if(f.equals("FizzBuzz") || s.equals("FizzBuzz")) 
            return Integer.parseInt(t) + 1;
        else if(t.equals("FizzBuzz")) return Integer.parseInt(s) + 2;
        else if(f.equals("Fizz")){
            if(t.equals("Buzz")) return Integer.parseInt(s) + 2;
            else return Integer.parseInt(t) + 1;
        }
        else if(s.equals("Fizz")){
            if(t.equals("Buzz")) return Integer.parseInt(f) + 3;
            else return Integer.parseInt(t) + 1;
        }
        else if(t.equals("Fizz")){
            if(f.equals("Buzz")) return Integer.parseInt(s) + 2;
            else if(s.equals("Buzz")) return Integer.parseInt(f) + 3;
            else return Integer.parseInt(f) + 3;
        }
        return 0;
    }
}