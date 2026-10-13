def dfs(x, y, num):
    visited[x][y] = True
    cnt = 1

    for k in range(4):
        nx, ny = x + dx[k], y + dy[k]

        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        if visited[nx][ny]:
            continue
        if grid[nx][ny] == num:
            cnt += dfs(nx, ny, num)
    return cnt
        

n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

visited = [[False] * n for _ in range(n)]

biggestBlock = 0
boom = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            cnt = dfs(i, j, grid[i][j])
            if cnt >= 4:
                boom += 1
            if cnt > biggestBlock:
                biggestBlock = cnt

print(boom, biggestBlock)