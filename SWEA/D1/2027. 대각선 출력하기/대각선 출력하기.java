import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append("#++++").append('\n');
        sb.append("+#+++").append('\n');
        sb.append("++#++").append('\n');
        sb.append("+++#+").append('\n');
        sb.append("++++#").append('\n');
        System.out.print(sb);
    }
}