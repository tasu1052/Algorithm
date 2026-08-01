import java.util.*;

class Solution {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int cutA, cutB;

    public int solution(int n, int[][] wires) {

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 그래프 생성
        for (int i = 0; i < wires.length; i++) {
            int s = wires[i][0];
            int e = wires[i][1];

            graph[s].add(e);
            graph[e].add(s);
        }

        int answer = Integer.MAX_VALUE;

        // 간선을 하나씩 끊어보기
        for (int i = 0; i < wires.length; i++) {

            cutA = wires[i][0];
            cutB = wires[i][1];

            visited = new boolean[n + 1];

            // 끊어진 한쪽 전력망의 송전탑 개수
            int count = dfs(1);

            // 다른 쪽 전력망 송전탑 개수
            int other = n - count;

            answer = Math.min(
                answer,
                Math.abs(count - other)
            );
        }

        return answer;
    }

    static int dfs(int now) {
        visited[now] = true;

        int count = 1;

        for (int next : graph[now]) {

            // 현재 끊어놓은 간선은 건너뜀
            if ((now == cutA && next == cutB) ||
                (now == cutB && next == cutA)) {
                continue;
            }

            if (!visited[next]) {
                count += dfs(next);
            }
        }

        return count;
    }
}