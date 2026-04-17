def solution(n):
    tmp = n
    cnt = 0
    for ch in str(bin(n)[2:]):
        if ch == "1":
            cnt += 1
            
    while True:
        tmp += 1
        tmpCnt = 0
        for ch in str(bin(tmp)[2:]):
            if ch == "1":
                tmpCnt += 1
        if tmpCnt == cnt:
            break
    
    answer = tmp
    return answer