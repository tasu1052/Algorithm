import java.io.*;
import java.util.*;

public class Main {
    static String[] cmd = {"D", "S", "L", "R"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[10000];
            int[] prev = new int[10000];      // 이전 숫자
            char[] how = new char[10000];     // 사용한 명령

            Queue<Integer> q = new ArrayDeque<>();
            q.add(start);
            visited[start] = true;

            while (!q.isEmpty()) {
                int now = q.poll();
                if (now == end) break;

                // D
                int d = (now * 2) % 10000;
                if (!visited[d]) {
                    visited[d] = true;
                    prev[d] = now;
                    how[d] = 'D';
                    q.add(d);
                }

                // S
                int s = (now == 0) ? 9999 : now - 1;
                if (!visited[s]) {
                    visited[s] = true;
                    prev[s] = now;
                    how[s] = 'S';
                    q.add(s);
                }

                // L
                int l = (now % 1000) * 10 + now / 1000;
                if (!visited[l]) {
                    visited[l] = true;
                    prev[l] = now;
                    how[l] = 'L';
                    q.add(l);
                }

                // R
                int r = (now % 10) * 1000 + now / 10;
                if (!visited[r]) {
                    visited[r] = true;
                    prev[r] = now;
                    how[r] = 'R';
                    q.add(r);
                }
            }

            StringBuilder ans = new StringBuilder();
            int cur = end;
            while (cur != start) {
                ans.append(how[cur]);
                cur = prev[cur];
            }

            sb.append(ans.reverse()).append('\n');
        }
        System.out.println(sb);
    }
}