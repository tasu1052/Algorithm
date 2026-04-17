def solution(clothes):
    count = {}
    
    for name, kind in clothes:
        count[kind] = count.get(kind, 0) + 1
        
    answer = 1
    
    for value in count.values():
        answer *= value + 1
        
    return answer - 1
    
    