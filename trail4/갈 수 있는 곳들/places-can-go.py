from collections import deque

n, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
points = [tuple(map(int, input().split())) for _ in range(k)]

# Please write your code here.
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

q = deque()
cnt = 0

visited = [[False] * n for _ in range(n)]
for p in points:
    q.append((p[0]-1, p[1]-1))
    visited[p[0]-1][p[1]-1] = True
    cnt += 1




while q:
    x, y = q.popleft()

    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]

        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        if visited[nx][ny]:
            continue
        if grid[nx][ny] == 0:
            q.append((nx, ny))
            visited[nx][ny] = True
            cnt += 1

print(cnt)