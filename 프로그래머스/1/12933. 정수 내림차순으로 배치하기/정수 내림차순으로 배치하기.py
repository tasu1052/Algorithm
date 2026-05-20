def solution(n):
    answer = []
    
    while n > 0:
        answer.append(n % 10)
        n //= 10
    answer.sort()
    
    ans = 0
    digit = 1
    
    for num in answer:
        ans += num * digit
        digit *= 10
    return ans