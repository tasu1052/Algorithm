def solution(elements):
    s = set()
    n = len(elements)
    extended = elements * 2
    
    prefix = [0] * (2 * n + 1)
    for i in range(2 * n):
        prefix[i+1] = prefix[i] + extended[i]
    
    for length in range(1, n+1):
        for start in range(n):
            total = prefix[start + length] - prefix[start]
            s.add(total)
            
    return len(s)