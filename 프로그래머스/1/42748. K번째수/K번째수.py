def solution(array, commands):
    answer = []
    for i, j, k in commands:
        newList = array[i-1:j]
        newList.sort()
        answer.append(newList[k-1])
        
    return answer