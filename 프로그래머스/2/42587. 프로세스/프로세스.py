from collections import deque
def solution(priorities, location):
    q = deque(enumerate(priorities))
    
    order = 0
    while q:
        idx, priority = q.popleft()
        
        if q and priority < max(p for _, p in q):
            q.append((idx, priority))
        else:
            order += 1
            if idx == location:
                return order
                    
    