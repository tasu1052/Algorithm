import math
def lcm(a, b):
    return a * b // math.gcd(a, b)
def solution(arr):
    result = arr[0]
    
    for i in range(1, len(arr)):
        result = lcm(result, arr[i])
    return result