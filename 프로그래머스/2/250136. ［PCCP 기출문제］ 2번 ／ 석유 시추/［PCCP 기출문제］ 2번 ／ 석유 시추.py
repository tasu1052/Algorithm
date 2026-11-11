from collections import deque
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
n, m = 0, 0
'''
bfs로 체크하고 열마다 석유 체크해서 최대값 return하면 됨
'''
def solution(land):
    global n, m
    answer = 0
    n = len(land)
    m = len(land[0])
    
    visited = [[False] * m for _ in range(n)]
    oil = [0] * m
    
    for i in range(n):
        for j in range(m):
            if not visited[i][j] and land[i][j] == 1:
                cnt, cols = bfs(land, i, j, visited)

                for col in cols:
                    oil[col] += cnt

    return max(oil)

def bfs(land, sx, sy, visited):
    q = deque()
    visited[sx][sy] = True
    q.append((sx, sy))
    
    cnt = 1
    cols = {sy}
    
    while q:
        x, y = q.popleft()
        
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]
            
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if visited[nx][ny]:
                continue
            if land[nx][ny] == 1:
                visited[nx][ny] = True
                q.append((nx, ny))
                cnt += 1
                cols.add(ny)
                
    return cnt, cols