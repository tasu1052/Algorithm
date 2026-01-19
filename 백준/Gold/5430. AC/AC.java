import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String com = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            Deque<Integer> q = new ArrayDeque<>();

            if (n > 0) {
                s = s.substring(1, s.length() - 1);
                String[] arr = s.split(",");
                for (String x : arr) {
                    q.add(Integer.parseInt(x));
                }
            }

            boolean reverse = false;
            boolean isError = false;

            for (int i = 0; i < com.length(); i++) {
                char c = com.charAt(i);

                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (q.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (reverse) q.pollLast();
                    else q.pollFirst();
                }
            }

            if (isError) {
                sb.append("error\n");
                continue;
            }

            sb.append("[");
            while (q.size() > 1) {
                if (reverse) sb.append(q.pollLast()).append(",");
                else sb.append(q.pollFirst()).append(",");
            }
            if (!q.isEmpty()) sb.append(q.poll());
            sb.append("]\n");
        }

        System.out.print(sb);
    }
}
