def solution(d, budget):
    department = sorted(d)
    answer = 0
    
    for de in department:
        budget -= de
        
        if budget < 0:
            break
        answer += 1
    return answer