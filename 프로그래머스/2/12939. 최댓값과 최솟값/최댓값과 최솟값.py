def solution(s):
    arr = list(map(int, s.split(" ")))
    maxN = max(arr)
    minN = min(arr)
    return str(minN) + " " + str(maxN)