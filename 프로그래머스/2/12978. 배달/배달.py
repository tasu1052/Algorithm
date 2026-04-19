from collections import deque
graph = [[]]
def solution(N, road, K):
    global graph
    graph = [[] for _ in range(N+1)]
    
    for s, e, c in road:
        graph[s].append((e, c))
        graph[e].append((s, c))
        
    dist = [10000000] * (N+1)
    
    dijkstra(1, 0, dist)
    
    answer = 0
    for distance in dist:
        if distance <= K:
            answer += 1

    return answer

def dijkstra(start, cost, dist):
    global graph
    q = deque()
    dist[start] = 0
    q.append((start, cost))
    
    while q:
        now_node, now_cost = q.popleft()
        
        for next_node, next_cost in graph[now_node]:
            if dist[next_node] > dist[now_node] + next_cost:
                dist[next_node] = dist[now_node] + next_cost
                q.append((next_node, next_cost))
    