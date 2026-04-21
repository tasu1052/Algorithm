def solution(s):
    
    pnum = 0
    ynum = 0
    
    for ch in s:
        if ch == "P" or ch == "p":
            pnum += 1
        elif ch == "Y" or ch == "y":
            ynum += 1
    
    if pnum == ynum:
        return True
    return False