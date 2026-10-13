def dfs(x, y, k):
    stack = [(x, y)]
    visited[x][y] = True

    while stack:
        x, y = stack.pop()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if visited[nx][ny]:
                continue
            if grid[nx][ny] > k:
                visited[nx][ny] = True
                stack.append((nx, ny))

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

maximum = 0
for i in range(n):
    for j in range(m):
        if grid[i][j] > maximum:
            maximum = grid[i][j]

ansK = 1
ansR = 0

for k in range(1, maximum):
    visited = [[False] * m for _ in range(n)]
    region = 0
    for i in range(n):
        for j in range(m):
            if grid[i][j] > k and not visited[i][j]:
                dfs(i, j, k)
                region += 1

    if region > ansR:
        ansK = k
        ansR = region

print(ansK, ansR)