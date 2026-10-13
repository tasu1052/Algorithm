n, k, t = input().split()
n, k = int(n), int(k)
str = [input() for _ in range(n)]

# Please write your code here.
word = []

for s in str:
    if s[:len(t)] == t:
        word.append(s)

word.sort()
print(word[k-1])