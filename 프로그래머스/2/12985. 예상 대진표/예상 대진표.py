def solution(n,a,b):
    turn = 0
    
    if (a + 1) // 2 == (b + 1) // 2:
        return 1
    
    while a != b:
        a = (a + 1) // 2
        b = (b + 1) // 2
        turn += 1

    return turn