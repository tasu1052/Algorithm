import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int count = 0;
        for(int i=5; n/i>=1; i*=5)
            count+=n/i;
        System.out.print(count);
    }
}