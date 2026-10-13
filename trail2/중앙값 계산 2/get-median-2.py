n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.

word = []
for idx, num in enumerate(arr):
    word.append(num)
    if (idx + 1) % 2 == 1:
        word.sort()
        i = len(word) // 2
        print(word[i], end= " ")