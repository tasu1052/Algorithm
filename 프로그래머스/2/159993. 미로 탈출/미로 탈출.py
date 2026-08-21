from collections import deque
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
def solution(maps):
    sx, sy = 0, 0
    lx, ly = 0, 0
    ex, ey = 0, 0

    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] == 'S':
                sx, sy = i, j
            elif maps[i][j] == 'L':
                lx, ly = i, j
            elif maps[i][j] == 'E':
                ex, ey = i, j

    toLever = bfs(sx, sy, lx, ly, maps)

    if toLever == -1:
        return -1

    toExit = bfs(lx, ly, ex, ey, maps)

    if toExit == -1:
        return -1

    return toLever + toExit

def bfs(sx, sy, fx, fy, maps):
    q = deque()
    dist = [[-1] * len(maps[0]) for _ in range(len(maps))]
    dist[sx][sy] = 0
    q.append([sx, sy])
    
    while q:
        now = q.popleft()
        x, y = now[0], now[1]

        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]

            if nx < 0 or nx >= len(maps) or ny < 0 or ny >= len(maps[0]):
                continue
            if maps[nx][ny] == 'X' or dist[nx][ny] != -1:
                continue

            dist[nx][ny] = dist[x][y] + 1

            if nx == fx and ny == fy:
                return dist[nx][ny]

            q.append([nx, ny])
            
        
    return -1