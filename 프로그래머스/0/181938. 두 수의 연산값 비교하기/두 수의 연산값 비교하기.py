def solution(a, b):
    resultA = str(a) + str(b)
    resultB = 2 * a * b
    if int(resultA) >= resultB:
        return int(resultA)
    else :
        return resultB