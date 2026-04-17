def solution(k, tangerine):
    count = {}
    
    for i in tangerine:
        count[i] = count.get(i, 0) + 1
        
    result = sorted(count.items(), key=lambda x : x[1], reverse = True)
    
    total = 0
    cnt = 0
    
    for key, value in result:
        total += value
        cnt += 1
        if total >= k:
            break
    
    return cnt