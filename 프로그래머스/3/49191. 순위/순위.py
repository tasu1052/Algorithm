from collections import deque
graphA = [[]]
graphB = [[]]
def solution(n, results):
    global graphA, graphB
    
    graphA = [[] for _ in range(n+1)]
    graphB = [[] for _ in range(n+1)]
    
    for s, e in results:
        graphA[s].append(e)
        graphB[e].append(s)
        
    cnt = 0
    for i in range(1, n+1):
        visited = [False] * (n+1)
        bfs(i, graphA, visited)
        bfs(i, graphB, visited)
        
        if check(visited, n):
            cnt += 1
    return cnt

def bfs(start, graph,visited):
    q = deque()
    q.append(start)
    visited[start] = True
    
    while q:
        now = q.popleft()
        
        for nxt in graph[now]:
            if not visited[nxt]:
                visited[nxt] = True
                q.append(nxt)
                
def check(visited, n):
    for i in range(1, n+1):
        if not visited[i]:
            return False
    return True
        
            