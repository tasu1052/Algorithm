n = int(input())
commands = [tuple(input().split()) for _ in range(n)]
x = []
dir = []
for num, direction in commands:
    x.append(int(num))
    dir.append(direction)

dic = {}
pos = 0
for i in range(len(commands)):
    if dir[i] == 'L':
        for _ in range(x[i]):
            dic[pos] = 'W'
            pos -= 1
        pos += 1
    else:
        for _ in range(x[i]):
            dic[pos] = 'B'
            pos += 1
        pos -= 1

wcnt = 0
bcnt = 0
for n in dic.values():
    if n == 'W':
        wcnt += 1
    else:
        bcnt += 1

print(wcnt, bcnt)
    