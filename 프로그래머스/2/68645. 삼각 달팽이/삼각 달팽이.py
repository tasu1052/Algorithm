def solution(n):
    answer = [[0] * n for _ in range(n)]
    num = 1
    
    dx = [1, 0, -1]
    dy = [0, 1, -1]
    
    d = 0
    x, y = 0, 0
    
    for i in range(n * (n+1) // 2):
        answer[x][y] = num
        
        x += dx[d]
        y += dy[d]
        num += 1
        
        if x < 0 or x >= len(answer) or y < 0 or y >= len(answer[0]) or answer[x][y] != 0:
            x -= dx[d]
            y -= dy[d]
            
            d = (d + 1) % 3
            
            x += dx[d]
            y += dy[d]
        
    ans = []
    for i in range(n):
        for j in range(i+1):
            ans.append(answer[i][j])
    return ans