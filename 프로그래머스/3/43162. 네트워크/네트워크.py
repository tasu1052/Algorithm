from collections import deque
visited = []
graph = []
def solution(n, computers):
    #아직 방문 안한 경우 bfs 돌아서 전부 방문 처리
    #방문처리 하는 경우 cnt 증가 cnt 리턴
    global visited, graph
    cnt = 0
    visited = [False] * n
    graph = [[] for _ in range(n)]
    
    for i in range(len(computers)):
        for j in range(len(computers[i])):
            if i != j and computers[i][j] == 1:
                graph[i].append(j)
    
    for i in range(n):
        if not visited[i]:
            bfs(i)
            cnt += 1
    return cnt
def bfs(start):
    q = deque()
    global visited, graph
    visited[start] = True
    q.append(start)
    
    while q:
        now = q.popleft()
        
        for next in graph[now]:
            if not visited[next]:
                visited[next] = True
                q.append(next)