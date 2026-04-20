from collections import deque
graph = [[]]
def solution(n, roads, sources, destination):
    global graph
    graph = [[] for _ in range(n+1)]
    
    for s, e in roads:
        graph[s].append(e)
        graph[e].append(s)
        
    dist = [-1] * (n+1)
    
    bfs(destination, dist)
    
    answer = []
    for source in sources:
        answer.append(dist[source])
        
    return answer

def bfs(start, dist):
    global graph
    q = deque()
    q.append(start)
    dist[start] = 0
    
    while q:
        now= q.popleft()
        
        for next in graph[now]:
            if dist[next] == -1:
                dist[next] = dist[now] + 1
                q.append(next)
                
        
    