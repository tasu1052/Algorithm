import java.io.*;
import java.util.*;

public class Main {
    static char[] c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null){
            int N = Integer.parseInt(input);
            int num = (int)Math.pow(3, N);
            c = new char[num];
            Arrays.fill(c, '-');

            can(0, num);

            System.out.println(new String(c));
        }
    }
    static void can(int start, int size){
        if(size==1) return;

        int third = size / 3;

        for(int i=start + third; i< start + 2*third; i++)
            c[i] = ' ';

        can(start, third);
        can(start + third*2, third);
    }
}