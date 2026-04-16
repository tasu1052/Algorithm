def solution(n):
    cnt = 0
    for i in range(1, n+1):
        total = 0
        num = i
        while total < n:
            total += num
            num += 1
        if total == n:
            cnt += 1
    answer = cnt
    return answer