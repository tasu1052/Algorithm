def solution(players, m, k):
    answer = 0
    curServer = {}
    
    for idx in range(len(players)):
        curServer[idx] = curServer.get(idx, 0)
        
    for idx, player in enumerate(players):
        additional = (player - curServer[idx] * m) // m
        if additional > 0:
            answer += additional
                
            for i in range(idx, idx+k):
                if i >= len(players):
                    break
                curServer[i] = curServer.get(i) + additional
        
        
    return answer