def solution(routes):
    #정렬하고
    routes.sort(key=lambda x : x[1])
    answer = 0
    
    camera = -30001
    
    for start, end in routes:
        if start > camera:
            camera = end
            answer += 1
            
        
    return answer