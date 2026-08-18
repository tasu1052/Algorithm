def solution(keymap, targets):
    answer = []
    alpha = {}
    
    for key in keymap:
        for i in range(len(key)):
            if alpha.get(key[i]) == None or alpha.get(key[i]) > i+1:
                alpha[key[i]] = i + 1
                print(alpha[key[i]])
            
    for target in targets:
        cnt = 0
        flag = True
        for i in range(len(target)):
            tmp = alpha.get(target[i])
            if tmp == None:
                flag = False
                answer.append(-1)
                break
            cnt += tmp
        if flag:
            answer.append(cnt)
            
    return answer