import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[4 * N];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, N, 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, N, 1, b, diff);
            } else {
                sb.append(query(1, N, 1, b, (int)c)).append('\n');
            }
        }

        System.out.print(sb);
    }

    // 세그먼트 트리 초기화
    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] =
                init(start, mid, node * 2)
              + init(mid + 1, end, node * 2 + 1);
    }

    // index 위치 값이 diff만큼 바뀌었을 때 갱신
    static void update(int start, int end, int node, int index, long diff) {
        if (index < start || index > end) return;

        tree[node] += diff;

        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
    }

    // left ~ right 구간 합
    static long query(int start, int end, int node, int left, int right) {
        // 완전히 범위 밖
        if (right < start || end < left) return 0;

        // 완전히 포함
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right)
             + query(mid + 1, end, node * 2 + 1, left, right);
    }
}