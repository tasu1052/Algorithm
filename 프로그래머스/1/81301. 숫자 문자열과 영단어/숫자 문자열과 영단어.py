def solution(s):
    answer = ''
    dic = {'zero' : '0', 'one' : '1', 'two' : '2', 'three' : '3', 'four' : '4', 
           'five' : '5', 'six' : '6', 'seven' : '7', 'eight' : '8', 'nine' : '9'}
    
    idx = 0;
    tmp = ''
    while idx < len(s): #idx가 s길이보다 작을 때까지
        if ord(s[idx]) >= 48 and ord(s[idx]) <= 57:
            answer += s[idx]
            idx += 1
        else:
            tmp += s[idx]
            idx += 1
            
            if tmp in dic:
                answer += dic[tmp]
                tmp = ''
    return int(answer)