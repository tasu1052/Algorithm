from collections import deque
n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

visited = [[False] * m for _ in range(n)]

q = deque()

visited[0][0] = True
q.append((0, 0))

while q:
    x, y = q.popleft()

    for k in range(4):
        nx, ny = x + dx[k], y + dy[k]

        if not (0 <= nx < n and 0 <= ny < m):
            continue
        if visited[nx][ny] or a[nx][ny] == 0:
            continue

        visited[nx][ny] = True
        q.append((nx, ny))


if visited[n-1][m-1]:
    print(1)
else:
    print(0)