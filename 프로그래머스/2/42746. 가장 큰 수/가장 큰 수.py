def solution(numbers):
    newList = list(map(str, numbers))
    newList.sort(key = lambda x : x*3, reverse = True)
    
    answer = ''
    
    for ch in newList:
        answer += ch
    return str(int(answer))