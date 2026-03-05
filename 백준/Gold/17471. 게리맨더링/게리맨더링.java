import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class Main {
    static int N;
    static int[] area;
    static int[] color = {-1, 1};
    static ArrayList<Integer>[] A;
    static int ans = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        area = new int[N+1];
        visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) area[i] = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        for(int i=0; i<=N; i++) A[i] = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++) {
                int e = Integer.parseInt(st.nextToken());
                A[i].add(e);
            }
        }

        for(int i=1; i<N; i++) {
            dfs(1, 0, i);
        }


        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
    static void dfs(int idx, int cnt, int target) {
        if(cnt == target) {
            if(isConnected(true) && isConnected(false)){
                int sumA = 0, sumB = 0;
                for (int i = 1; i <= N; i++) {
                    if (visited[i]) sumA += area[i];
                    else sumB += area[i];
                }
                ans = Math.min(ans, Math.abs(sumA - sumB));
            }
            return;
        }

        if(idx > N) return;

        if(N - idx + 1 < target - cnt) return;

        visited[idx] = true;
        dfs(idx + 1, cnt + 1, target);

        visited[idx] = false;
        dfs(idx + 1, cnt + 1, target);
    }
    static boolean isConnected(boolean group) {
        boolean[] vis = new boolean[N + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        // 그룹에 속한 시작점 찾기
        int start = -1;
        int total = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == group) {
                total++;
                if (start == -1) start = i;
            }
        }
        if (total == 0) return false;

        q.add(start);
        vis[start] = true;
        int reached = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            reached++;
            for (int next : A[now]) {
                if (!vis[next] && visited[next] == group) {
                    vis[next] = true;
                    q.add(next);
                }
            }
        }

        return reached == total;
    }
}