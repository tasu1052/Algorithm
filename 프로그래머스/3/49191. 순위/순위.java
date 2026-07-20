import java.util.*;

class Solution {
    static ArrayList<Integer>[] winList;
    static ArrayList<Integer>[] loseList;

    public int solution(int n, int[][] results) {
        winList = new ArrayList[n + 1];
        loseList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            winList[i] = new ArrayList<>();
            loseList[i] = new ArrayList<>();
        }

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            winList[winner].add(loser);
            loseList[loser].add(winner);
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int winCount = bfs(i, winList, n);
            int loseCount = bfs(i, loseList, n);

            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    static int bfs(int start, ArrayList<Integer>[] graph, int n) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        visited[start] = true;
        queue.add(start);

        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }

        return count;
    }
}