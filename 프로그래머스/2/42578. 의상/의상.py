def solution(clothes):
    clothesDict = {}
    
    for name, classs in clothes:
        clothesDict[classs] = clothesDict.get(classs, 0) + 1
        
    ans = 1
    
    for classs in clothesDict:
        ans *= clothesDict[classs] + 1
        
    return ans - 1
    
    