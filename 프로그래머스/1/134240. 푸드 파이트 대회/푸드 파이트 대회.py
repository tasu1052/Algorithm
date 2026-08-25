def solution(food):
    first = ''
    
    for i in range(1, len(food)):
        cnt = food[i] // 2
        
        for j in range(cnt):
            first += str(i)
            
    second = first[::-1]
    
    answer = first + '0' + second
    
    return answer