from collections import deque

n, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
r, c = map(int, input().split())
r, c = r-1, c-1
# Please write your code here.
dx = [0, 1, 0 ,-1]
dy = [1, 0, -1, 0]

for i in range(k):
    q = deque()
    visited = [[False] * n for _ in range(n)]

    q.append((r, c, grid[r][c]))
    visited[r][c] = True
    maxnum = 0
    best_r, best_c = r, c

    while q:
        x, y, num = q.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if not (0 <= nx < n and 0 <= ny < n):
                continue
            if visited[nx][ny] or grid[nx][ny] >= num:
                continue

            visited[nx][ny] = True
            q.append((nx, ny, num))

            if grid[nx][ny] > maxnum:
                maxnum = grid[nx][ny]
                best_r, best_c = nx, ny
            elif grid[nx][ny] == maxnum:
                if best_r > nx:
                    best_r = nx
                    best_c = ny
                elif best_r == nx and best_c > ny:
                    best_r = nx
                    best_c = ny
    if maxnum == 0:
        break
    r, c = best_r, best_c                
print(r+1, c+1)