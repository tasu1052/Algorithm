visited = []
answer = []
path = []
def solution(tickets):
    global visited, answer, path
    
    tickets.sort()
    visited = [False] * len(tickets)
    answer = []
    path = ["ICN"]
    
    dfs("ICN", tickets, 0)
    
    return answer

def dfs(now, tickets, cnt):
    global visited, answer, path
    
    if cnt == len(tickets):
        answer = path[:]
        return True
    
    for i in range(len(tickets)):
        if not visited[i] and tickets[i][0] == now:
            visited[i] = True
            path.append(tickets[i][1])
    
            if dfs(tickets[i][1], tickets, cnt + 1):
                return True
            
            visited[i] = False
            path.pop()
    return False