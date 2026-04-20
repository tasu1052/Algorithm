def solution(n, times):
    times.sort()
    
    start = 1
    end = times[-1] * n
    result = 0
    
    while start <= end:
        mid = (start + end) // 2
        sum = 0
        
        for i in range(len(times)):
            sum += mid // times[i]
            
            if sum >= n:
                break
        
        if sum >= n:
            end = mid -1
            result = mid
        else:
            start = mid + 1
            
    return result