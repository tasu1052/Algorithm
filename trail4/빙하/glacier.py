from collections import deque
n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

visited = [[False] * m for _ in range(n)]
q = deque()

q.append((0, 0))
visited[0][0] = True
time = 0

while True:
    nextMelt = []
    while q:
        x, y = q.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if not (0 <= nx < n and 0 <= ny < m):
                continue
            if visited[nx][ny]:
                continue
            
            visited[nx][ny] = True
            
            if a[nx][ny] == 0:
                q.append((nx, ny))
            else:
                nextMelt.append((nx, ny))

    if len(nextMelt) == 0:
        break

    time += 1
    cnt = len(nextMelt)

    for l in nextMelt:
        a[l[0]][l[1]] = 0
        q.append((l[0], l[1]))

print(time, cnt)