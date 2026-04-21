import sys
input = sys.stdin.readline

N, M = map(int, input().split())
trees = list(map(int, input().split()))

left = 0
right = max(trees)
result = 0

while left <= right:
    mid = (left + right) // 2
    total = 0

    for i in range(len(trees)):
        if trees[i] > mid:
            total += trees[i] - mid
            if total >= M:
                break

    if total >= M:
        left = mid + 1
        result = mid
    else:
        right = mid - 1
print(result)