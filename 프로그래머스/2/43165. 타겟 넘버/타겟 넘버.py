cnt = 0
def solution(numbers, target):
    global cnt
    cnt = 0
    dfs(numbers, target, 0, 0)
    return cnt
#numbers 배열에서 어떤 값을 더한 경우 뺀경우로 계속 dfs하기

def dfs(numbers, target, idx, total):
    global cnt
    if idx == len(numbers):
        if total == target:
            cnt += 1
        return
    
    dfs(numbers, target, idx + 1, total + numbers[idx])
    
    dfs(numbers, target, idx + 1, total - numbers[idx])