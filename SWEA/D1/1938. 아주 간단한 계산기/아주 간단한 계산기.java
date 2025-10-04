import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        sb.append(a+b).append('\n');
        sb.append(a-b).append('\n');
        sb.append(a*b).append('\n');
        sb.append(a/b).append('\n');

        System.out.print(sb);
    }
}