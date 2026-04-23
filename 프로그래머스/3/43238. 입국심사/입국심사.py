def solution(n, times):
    times.sort()
    result = 0
    
    left = 1
    right = times[-1] * n
    
    while left <= right:
        mid = (left + right) // 2
        total = 0
        
        for i in range(len(times)):
            total += mid // times[i]
            if total >= n:
                break
                
        if total >= n:
            right = mid -1
            result = mid
        else:
            left = mid +1
    return result