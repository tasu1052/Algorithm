visited = []
ans = 0
def solution(k, dungeons):
    global visited, ans
    visited = [False] * len(dungeons)
    ans = 0
    
    dfs(k, dungeons, 0)
    return ans

def dfs(k, dungeons, cnt):
    global visited, ans
    ans = max(ans, cnt)
    
    for i in range(len(dungeons)):
        if not visited[i] and k >= dungeons[i][0]:
            visited[i] = True
            dfs(k - dungeons[i][1], dungeons, cnt+1)
            visited[i] = False
    return
        