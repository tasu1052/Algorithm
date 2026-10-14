from itertools import combinations
from collections import deque

def bfs():
    q = deque()
    visited = [[False] * n for _ in range(n)]

    for i in range(k):
        q.append((r[i], c[i]))
        visited[r[i]][c[i]] = True

    cnt = len(q)

    while q:
        x, y = q.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if not (0 <= nx < n and 0 <= ny < n):
                continue
            if visited[nx][ny] or grid[nx][ny] == 1:
                continue

            visited[nx][ny] = True
            q.append((nx, ny))
            cnt += 1
    return cnt
    

n, k, m = map(int, input().split())

grid = [list(map(int, input().split())) for _ in range(n)]

r = []
c = []
for _ in range(k):
    ri, ci = map(int, input().split())
    r.append(ri - 1)
    c.append(ci - 1)

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

stone = []
for i in range(n):
    for j in range(n):
        if grid[i][j] == 1:
            stone.append((i, j))

cnt = 0
for com in list(combinations(stone, m)):
    for sc in com:
        grid[sc[0]][sc[1]] = 0
    cnt = max(cnt, bfs())
    for sc in com:
        grid[sc[0]][sc[1]] = 1

print(cnt)