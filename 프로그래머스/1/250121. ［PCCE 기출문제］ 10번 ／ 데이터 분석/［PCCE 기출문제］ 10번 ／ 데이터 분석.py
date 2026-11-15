def solution(data, ext, val_ext, sort_by):
    answer = []
    
    standard = 0
    if ext == 'code':
        standard = 0
    elif ext == 'date':
        standard = 1
    elif ext == 'maximum':
        standard = 2
    else:
        standard = 3
        
    for d in data:
        if d[standard] < val_ext:
            answer.append(d)
            
    s = 0
    if sort_by == 'code':
        s = 0
    elif sort_by == 'date':
        s = 1
    elif sort_by == 'maximum':
        s = 2
    else:
        s = 3
            
    answer.sort(key= lambda x : x[s])
    return answer