def solution(s):
    answer = []
    turn = 0
    totalZeroNum = 0
    while len(s) != 1:
        zeroNum = 0
        for i in s:
            if i == '0':
                zeroNum += 1
                
        totalZeroNum += zeroNum
        s = s.replace('0', '')
        l = len(s)
        s = format(l, 'b')
        
        turn += 1
    answer.append(turn)
    answer.append(totalZeroNum)
    return answer