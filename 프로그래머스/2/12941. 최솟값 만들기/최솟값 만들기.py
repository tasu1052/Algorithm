def solution(A,B):
    A.sort()
    B.sort(reverse = True)
    
    total = 0
    for i in range(len(A)):
        total += A[i] * B[i]
        
    return total