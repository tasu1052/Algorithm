import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String[] num = s.split("-");

        int sum = 0;
        String[] first = num[0].split("\\+");
        for (String f : first) {
            sum += Integer.parseInt(f);
        }

        for (int i = 1; i < num.length; i++) {
            String[] tmp = num[i].split("\\+");
            for (String t : tmp) {
                sum -= Integer.parseInt(t);
            }
        }
        System.out.print(sum);
    }
}