from collections import deque
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
INF = 10000
n = 0
m = 0
def solution(maps):
    global n, m
    n = len(maps)
    m = len(maps[0])
    dist = [[INF] * m for _ in range(n)]
    
    bfs(0, 0, maps, dist)
    
    if dist[n-1][m-1] == 10000:
        return -1
    return dist[n-1][m-1]

def bfs(i, j, maps, dist):
    global dx, dy, INF, n, m
    q = deque()
    dist[i][j] = 1
    q.append((i, j))
    
    while q:
        x, y = q.popleft()
        
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if dist[nx][ny] != INF:
                continue
            if maps[nx][ny] == 0:
                continue
                
            dist[nx][ny] = dist[x][y] + 1
            q.append((nx, ny))
    
    