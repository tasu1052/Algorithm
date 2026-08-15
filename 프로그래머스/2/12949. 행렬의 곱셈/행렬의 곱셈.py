def solution(arr1, arr2):
    answer = [[] for _ in range(len(arr1))]
    
    for i in range(len(arr1)): #행선택
        for cnt in range(len(arr2[0])): #행의 열만큼 반복
            total = 0
            idx = 0
            for j in arr1[i]: ##각 열 순회
                total += j * arr2[idx][cnt]
                idx += 1
            answer[i].append(total)
            
    return answer