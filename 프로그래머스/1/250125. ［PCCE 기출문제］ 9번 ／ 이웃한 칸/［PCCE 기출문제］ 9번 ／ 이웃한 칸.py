dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
def solution(board, h, w):
    answer = 0
    targetColor = board[h][w]
    
    for k in range(4):
        nx = h + dx[k]
        ny = w + dy[k]
        
        if nx < 0 or nx >= len(board) or ny < 0 or ny >= len(board[0]):
            continue
        
        if board[nx][ny] == targetColor:
            answer += 1
    return answer