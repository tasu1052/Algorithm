def solution(s):
    answer = 0
    now = s
    originIdx = 0
    
    while originIdx < len(s):
        firstLetter = s[originIdx]
        firstCnt = 1
        otherCnt = 0
        nextIdx = originIdx + 1
        while nextIdx < len(s) and firstCnt != otherCnt:
            if firstLetter == s[nextIdx]:
                firstCnt += 1
            else:
                otherCnt += 1
            nextIdx += 1
        
        originIdx = nextIdx
        answer += 1
    return answer