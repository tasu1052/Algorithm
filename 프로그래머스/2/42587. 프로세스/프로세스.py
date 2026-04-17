from collections import deque
def solution(priorities, location):
    q = deque(priorities)
    idx = deque()
    for i in range(len(priorities)):
        idx.append(i)
    
    order = 0
    while q:
        x = q.popleft()
        ix = idx.popleft()
        
        if q and x < max(q):
            q.append(x)
            idx.append(ix)
        else:
            order += 1
            if ix == location:
                return order
                    
    