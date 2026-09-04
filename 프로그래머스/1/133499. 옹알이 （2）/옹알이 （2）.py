def solution(babbling):
    #babbling 순회하고 그 단어 슬라이싱하면서
    #어떤 단어 만들어지면 ok 그 단어 전부 ok면 answer += 1
    dic = {'a' : 'aya',
           'y' : 'ye',
           'w' : 'woo',
           'm' : 'ma'}
    answer = 0

    for bab in babbling:
        idx = 0
        prev = ''
        
        while idx < len(bab):
            target = dic.get(bab[idx], '')
            
            if target == '':
                break
                
            if target == prev:
                break
                
            flag = True
            
            for i in range(len(target)):
                if idx + i >= len(bab):
                    flag = False
                    break
                    
                if target[i] != bab[idx+i]:
                    flag = False
                    break
            
            if not flag:
                break
                
            prev = target
            idx += len(target)
            
        if idx == len(bab):    
            answer += 1
                
    return answer