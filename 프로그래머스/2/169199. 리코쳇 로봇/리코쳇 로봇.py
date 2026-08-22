from collections import deque
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
def solution(board):
    answer = -1
    sx, sy = 0, 0
    ex, ey = 0, 0
    for idx, value in enumerate(board):
        if board[idx].find("R") != -1:
            sx = idx
            sy = board[idx].find("R")
        if board[idx].find("G") != -1:
            ex = idx
            ey = board[idx].find("G")
            
    answer = bfs(sx, sy, ex, ey, board)
    return answer

def bfs(sx, sy, ex, ey, board):
    q =  deque()
    visited = [[False] * len(board[0]) for _ in range(len(board))]
    visited[sx][sy] = True
    q.append([sx, sy, 0])
    
    while q:
        now = q.popleft()
        x = now[0]
        y = now[1]
        turn = now[2]
        
        if x == ex and y == ey:
            return turn
        
        for k in range(4):
            nx, ny = move(x, y, k, board, visited)
            
            if not visited[nx][ny]:
                visited[nx][ny] = True
                q.append([nx, ny, turn + 1])
            
    return -1
            
                
def move(x, y, k, board, visited):
    fx, fy = 0, 0
    while True:
        nx = x + dx[k]
        ny = y + dy[k]
        
        if nx < 0 or nx >= len(board) or ny < 0 or ny >= len(board[0]) or board[nx][ny] == 'D':
            nx -= dx[k]
            ny -= dy[k]
            fx, fy = nx, ny
            break;
            
        x = nx
        y = ny
            
    return [fx, fy]
            