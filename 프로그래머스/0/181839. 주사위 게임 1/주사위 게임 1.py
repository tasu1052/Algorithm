
def solution(a, b):
    sum = 0
    if a % 2 != 0 and b % 2 != 0:
        sum += a ** 2 + b ** 2
    elif a % 2 != 0 and b % 2 == 0:
        sum += 2 * (a + b)
    elif a % 2 == 0 and b % 2 != 0:
        sum += 2 * (a + b)
    else:
        sum += abs(a - b)
    answer = sum
    return answer