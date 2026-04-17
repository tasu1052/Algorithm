def solution(brown, yellow):
    total = brown + yellow
    
    for h in range(3, total + 1):
        if total % h == 0:
            w = total // h
            
            if w < h:
                continue
            
            if(w - 2) * (h - 2) == yellow:
                return [w, h]