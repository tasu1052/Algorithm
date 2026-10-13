def dfs(i, j):
    global visited
    visited[i][j] = True
    cnt = 1

    for k in range(4):
        nx, ny = i + dx[k], j + dy[k]

        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        if visited[nx][ny]:
            continue
        if grid[nx][ny] == 1:
            cnt += dfs(nx, ny)
    return cnt

n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

visited = [[False] * n for _ in range(n)]
answer = []

for i in range(n):
    for j in range(n):
        if grid[i][j] == 1 and not visited[i][j]:
            answer.append(dfs(i, j))

answer.sort()

print(len(answer))
for a in answer:
    print(a)