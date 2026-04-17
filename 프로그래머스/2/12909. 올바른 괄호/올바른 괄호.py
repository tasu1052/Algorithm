from collections import deque

def solution(s):
    
    q = deque()
    
    for ch in s:
        if ch == '(':
            q.append(ch)
        else:
            if not q:
                return False
            else:
                q.pop()
            
    if q:
        return False

    return True