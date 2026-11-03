import math
def solution(arrayA, arrayB):
    answer = 0
    
    answer = max(cal(arrayA, arrayB), cal(arrayB, arrayA))
    return answer

def cal(arrayA, arrayB):
    target = 0
    
    tmp = arrayA[0]
    for a in arrayA:
        tmp = math.gcd(tmp, a)
        
    pos = []
    for i in range(2, tmp+1):
        if tmp % i == 0:
            pos.append(i)
            
    for p in pos:
        flag = True
        for b in arrayB:
            if b % p == 0:
                flag = False
                break
        if flag:
            target = p
    return target