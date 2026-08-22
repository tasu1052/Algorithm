def solution(wallpaper):
    lx, ly, rx, ry = 51, 51, 0, 0
    
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] == '#':
                lx = min(lx, i)
                ly = min(ly, j)
                rx = max(rx, i)
                ry = max(ry, j)
                
    answer = [lx, ly, rx + 1, ry + 1]
    return answer