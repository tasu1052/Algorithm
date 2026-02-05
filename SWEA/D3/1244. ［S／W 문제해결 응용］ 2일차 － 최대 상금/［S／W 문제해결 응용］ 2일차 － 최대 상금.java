import java.io.*;
import java.util.*;

public class Solution {
    static char[] arr;
    static int swapCnt;
    static int best;
    static HashSet<String>[] visitedByDepth;

    static void dfs(int depth) {
        String cur = new String(arr);
        if (visitedByDepth[depth].contains(cur)) return;
        visitedByDepth[depth].add(cur);

        if (depth == swapCnt) {
            best = Math.max(best, Integer.parseInt(cur));
            return;
        }

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(i, j);
                dfs(depth + 1);
                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String numStr = st.nextToken();
            swapCnt = Integer.parseInt(st.nextToken());

            arr = numStr.toCharArray();
            best = 0;

            // depth별로 "현재 숫자 상태" 방문 체크 (중복 가지치기)
            visitedByDepth = new HashSet[swapCnt + 1];
            for (int i = 0; i <= swapCnt; i++) visitedByDepth[i] = new HashSet<>();

            dfs(0);

            out.append('#').append(tc).append(' ').append(best).append('\n');
        }

        System.out.print(out.toString());
    }
}
