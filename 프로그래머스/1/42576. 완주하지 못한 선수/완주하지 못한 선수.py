def solution(participant, completion):
    parD = {}
    
    for i in range(len(participant)):
        parD[participant[i]] = parD.get(participant[i], 0) + 1
        
    for i in range(len(completion)):
        parD[completion[i]] -= 1
    
    for name in parD:
        if parD[name] > 0:
            return name