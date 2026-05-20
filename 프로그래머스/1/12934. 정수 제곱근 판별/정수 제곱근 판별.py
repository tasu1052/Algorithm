def solution(n):
    num = n ** 0.5
    if num.is_integer():
        return (num+1) ** 2
    else:
        return -1
