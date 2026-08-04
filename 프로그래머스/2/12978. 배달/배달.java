import java.util.*;

class Solution {

    static class Node {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] graph;
    static int[] dist;

    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 그래프 생성
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int cost = r[2];

            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }

        dijkstra(1, N);

        int answer = 0;

        // 1번 마을도 거리 0이므로 포함
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    static void dijkstra(int start, int N) {
        final int INF = Integer.MAX_VALUE;

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        // 누적 비용이 작은 노드부터 꺼냄
        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int currentNode = now.to;
            int currentCost = now.cost;

            // 이미 더 짧은 경로를 찾았다면 무시
            if (currentCost > dist[currentNode]) {
                continue;
            }

            for (Node next : graph[currentNode]) {
                int newCost = currentCost + next.cost;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
    }
}