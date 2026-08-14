from collections import deque
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
def solution(maps):
    dist = [[-1] * len(maps[0]) for _ in range(len(maps))]
    
    bfs(maps, dist)
    
    return dist[len(maps)-1][len(maps[0])-1]

def bfs(maps, dist):
    q = deque()
    q.append((0, 0))
    dist[0][0] = 1
    
    while q:
        x, y = q.popleft()
        
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            
            if nx < 0 or nx >= len(maps) or ny < 0 or ny >= len(maps[0]):
                continue
            if maps[nx][ny] == 1 and dist[nx][ny] == -1:
                dist[nx][ny] = dist[x][y] + 1
                q.append((nx, ny))