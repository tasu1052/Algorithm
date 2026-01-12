import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] size;
    static HashMap<String, Integer> hm;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());

            hm = new HashMap<>();
            parent = new int[2 * F + 1];
            size = new int[2 * F + 1];

            int idx = 1;
            for (int i = 1; i <= 2 * F; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!hm.containsKey(a)) {
                    hm.put(a, idx++);
                }
                if (!hm.containsKey(b)) {
                    hm.put(b, idx++);
                }

                int result = union(hm.get(a), hm.get(b));
                sb.append(result).append('\n');
            }
        }

        System.out.print(sb);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
            size[a] += size[b];
        }
        return size[a];
    }
}
