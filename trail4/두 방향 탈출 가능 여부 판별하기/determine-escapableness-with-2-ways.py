def dfs(x, y):
    global flag
    if x == n-1 and y == m-1:
        flag = True
        return
    for k in range(2):
        nx, ny = x + dx[k], y + dy[k]

        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue
        if visited[nx][ny]:
            continue
        if grid[nx][ny] == 1:
            visited[nx][ny] = True
            dfs(nx, ny)

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
dx = [1, 0]
dy = [0, 1]

visited = [[False] * m for _ in range(n)]

flag = False
dfs(0, 0)

if flag:
    print(1)
else:
    print(0)