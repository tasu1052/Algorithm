def solution(n):
    arr = [[0] * n for _ in range(n)]
    for i in range(len(arr)):
        for j in range(len(arr)):
            if i == j:
                arr[i][j] = 1
    answer = arr
    return answer