from collections import deque
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
visited = [[]]
def solution(maps):
    global visited
    answer = []
    visited = [[False] * len(maps[0]) for _ in range(len(maps))]
    
    flag = False
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] != 'X' and not visited[i][j]:
                #print(i, j)
                answer.append(bfs(i, j, maps))
                
                if not flag:
                    flag = True
                    
    if not flag:
        answer.append(-1)
                    
    answer.sort()    
    return answer

def bfs(i, j, maps):
    global visited
    q = deque()
    visited[i][j] = True
    q.append((i, j))
    cnt = int(maps[i][j])
    
    while q:
        x, y = q.popleft()
        
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]
            if nx < 0 or nx >= len(maps) or ny < 0 or ny >= len(maps[0]):
                continue
            if visited[nx][ny]:
                continue
            if maps[nx][ny] != 'X':
                visited[nx][ny] = True
                q.append((nx, ny))
                cnt += int(maps[nx][ny])
         
    return cnt