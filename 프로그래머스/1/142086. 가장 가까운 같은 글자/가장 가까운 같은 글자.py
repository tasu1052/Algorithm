def solution(s):
    answer = []
    alpha = [-1] * 26
    
    for i in range(len(s)):
        if alpha[ord(s[i]) - 97] == -1:
            answer.append(-1)
            alpha[ord(s[i]) - 97] = i
        else:
            answer.append(i - alpha[ord(s[i]) - 97])
            alpha[ord(s[i]) - 97] = i
    return answer