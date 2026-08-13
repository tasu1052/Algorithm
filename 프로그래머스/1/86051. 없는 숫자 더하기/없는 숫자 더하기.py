def solution(numbers):
    cnt = [0] * 10
    answer = 0
    
    for num in numbers:
        cnt[num] += 1
        
    for i in range(len(cnt)):
        if cnt[i] == 0:
            answer += i
    return answer