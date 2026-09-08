def solution(lottos, win_nums):
    #lottos에서 맞은 개수 세고, zero 개수 세고
    #맞은 개수만큼 일단 현재 순위 저장해놓고 zero가 그거랑 맞는 경우 ++ 아니면 --    
    correctCnt = 0
    zeroCnt = 0
    
    for lotto in lottos:
        if lotto == 0:
            zeroCnt += 1
            continue
            
        for win_num in win_nums:
            if lotto == win_num:
                correctCnt += 1
    
    maxRank = min(6, 7 - correctCnt - zeroCnt)
    minRank = min(6, 7 - correctCnt)
    

        
    return [maxRank, minRank]