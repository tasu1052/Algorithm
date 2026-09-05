def solution(N, stages):
    #N순회하면서 그 안에서 stages 배열 한 번 더 돌면서 검사하면 될듯
    answer = []
    tmp = []
    stagePlayer = len(stages)
    
    for num in range(1, N+1):
        failedPlayer = 0
        failPercent = 0
        
        for stage in stages:
            if stage == num:
                failedPlayer += 1
                
        if stagePlayer == 0:
            tmp.append([num, failPercent])
            continue
        
        failPercent = failedPlayer / stagePlayer
        stagePlayer -= failedPlayer
        tmp.append([num, failPercent])
        
    tmp.sort(key=lambda x: (-x[1], x[0]))
    
    for r, f in tmp:
        answer.append(r)
        
    return answer