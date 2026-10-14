from collections import deque
from itertools import combinations
n, k, u, d = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
dir = []
for i in range(n):
    for j in range(n):
        dir.append((i, j))

# Please write your code here.
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

maxCnt = 0
for com in combinations(dir, k):
    cnt = 0
    visited = [[False] * n for _ in range(n)]
    q = deque()
    #print(com)
    for c in com:
        q.append((c[0], c[1]))
        visited[c[0]][c[1]] = True
    cnt = len(q)

    while q:
        x, y = q.popleft()

        for dr in range(4):
            nx, ny = x + dx[dr], y + dy[dr]

            if not (0 <= nx < n and 0 <= ny < n):
                continue
            if visited[nx][ny]:
                continue
            
            if u <= abs(grid[nx][ny] - grid[x][y]) <= d:
                visited[nx][ny] = True
                q.append((nx, ny))
                cnt += 1

    maxCnt = max(maxCnt, cnt)

print(maxCnt)
