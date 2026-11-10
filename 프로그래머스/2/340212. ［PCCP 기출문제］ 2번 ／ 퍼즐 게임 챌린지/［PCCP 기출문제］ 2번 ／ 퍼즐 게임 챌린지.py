def solution(diffs, times, limit):
    #diff의 최대값까지 순회?
    start = 1
    end = max(diffs)
    answer = 0
    
    while start <= end:
        mid = (start + end) // 2
        time = 0
        
        for i in range(len(diffs)):
            if diffs[i] <= mid:
                time += times[i]
            else:
                wrong = diffs[i] - mid
                time += wrong * (times[i-1] + times[i]) + times[i]
                
            if time > limit:
                break
                
        if time <= limit:
            end = mid - 1
            answer = mid
        else:
            start = mid + 1
    return answer

'''
diff <= level이면 time_cur만큼 소요
diff > level이면 diff - level번 틀림
퍼즐 틀릴 때마다 time_cur만큼 소요 추가로 time_prev 사용해 이전 퍼즐 다시 풀어어야함
'''