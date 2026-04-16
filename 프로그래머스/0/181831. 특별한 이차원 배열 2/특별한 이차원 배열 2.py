def solution(arr):
    flag = True
    for i in range(len(arr)):
        for j in range(len(arr[i])):
            if arr[i][j] != arr[j][i]:
                flag = False
                break
                
    if flag:
        answer = 1
    
    else:
        answer = 0
            
    return answer