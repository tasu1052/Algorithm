def solution(citations):
    citations.sort()
    
    answer = 0
    for i in range(len(citations)):
        upTotal = len(citations[i:])   # 현재 값 이상인 논문 수
        
        if citations[i] >= upTotal:
            answer = upTotal
            break
                
    return answer