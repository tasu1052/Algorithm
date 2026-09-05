def solution(babbling):
    #딕셔너리에 알파벳들 적어놓고
    #babbling 순회하면서 되는지 검사
    #검사 중에 안되면 바로 다음꺼 넘어가고 검사 통과 시 answer++
    words = {'a' : 'aya',
             'y' : 'ye',
             'w' : 'woo',
             'm' : 'ma'}
    
    answer = 0
    
    for bab in babbling:
        idx = 0
        prev = ''
        
        while idx < len(bab):
            target = words.get(bab[idx], '')
            
            if target == '':
                break
                
            if target == prev:
                break
                
            flag = True
                
            for i in range(len(target)):
                if idx + i >= len(bab):
                    flag = False
                    break
                if target[i] != bab[idx + i]:
                    flag = False
                    break
            
            if not flag:
                break
            
            prev = target
            idx += len(target)
            
        if idx == len(bab):
            answer += 1
            
                
    return answer