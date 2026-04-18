from collections import deque
graph = [[]]
def solution(n, edge):
    global graph
    graph = [[] for _ in range(n+1)]
    dist = [-1] * (n+1)
    for s, e in edge:
        graph[s].append(e)
        graph[e].append(s)
    
    bfs(1, dist)
    maxDist = max(dist)
    
    answer = 0
    for i in range(n+1):
        if dist[i] == maxDist:
            answer += 1
    return answer

def bfs(start, dist):
    global graph
    q = deque()
    dist[start] = 0
    q.append(start)
    
    while q:
        now = q.popleft()
        
        for next in graph[now]:
            if dist[next] == -1:
                dist[next] = dist[now] + 1
                q.append(next)
    