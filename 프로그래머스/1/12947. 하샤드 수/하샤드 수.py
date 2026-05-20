def solution(x):
    checkNum = x
    total = 0
    
    while x > 0:
        total += x % 10
        x //= 10
        
    if checkNum % total == 0:
        return True
    else:
        return False