import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        int time = 0;
        
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i); 

            if (ch == 'A' || ch == 'B' || ch == 'C')
                time += 3;
            else if (ch == 'D' || ch == 'E' || ch == 'F')
                time += 4;
            else if (ch == 'G' || ch == 'H' || ch == 'I')
                time += 5;
            else if (ch == 'J' || ch == 'K' || ch == 'L')
                time += 6;
            else if (ch == 'M' || ch == 'N' || ch == 'O')
                time += 7;
            else if (ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S')
                time += 8;
            else if (ch == 'T' || ch == 'U' || ch == 'V')
                time += 9;
            else if (ch == 'W' || ch == 'X' || ch == 'Y' || ch == 'Z')
                time += 10;
        }
        System.out.print(time);
    }
}