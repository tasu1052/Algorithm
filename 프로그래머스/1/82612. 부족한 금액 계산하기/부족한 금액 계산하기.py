def solution(price, money, count):
    answer = 0
    total = 0
    for cnt in range(1, count+1):
        total += price * cnt
    answer = total - money
    if answer <= 0:
        return 0
    return answer