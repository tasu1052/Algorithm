def solution(skill, skill_trees):
    skillSet = set()
    
    for s in skill:
        skillSet.add(s)
        
    answer = 0
    
    now = skill[0]
    
    for st in skill_trees:
        idx = 0
        now = skill[idx]
        flag = True
        for s in st:
            if s not in skillSet:
                continue
            else:
                if s != now:
                    flag = False
                    break
                else:
                    idx += 1
                    if idx < len(skill):
                        now = skill[idx]
                    
        if flag:
            answer += 1
            
            
    
    return answer