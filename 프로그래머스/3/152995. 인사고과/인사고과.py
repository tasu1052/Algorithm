def solution(scores):
    wanho_a, wanho_b = scores[0]
    wanho_sum = wanho_a + wanho_b
    
    scores.sort(key=lambda x: (-x[0], x[1]))
    
    answer = 1
    max_b = 0
    
    for a, b in scores:
        # 인센티브 대상 탈락
        if b < max_b:
            if a == wanho_a and b == wanho_b:
                return -1
            continue
        
        # 살아남은 사람 중 완호보다 합이 크면 등수 밀림
        if a + b > wanho_sum:
            answer += 1
        
        max_b = max(max_b, b)
    
    return answer