a, b = map(int, input().strip().split(' '))
for i in range(b):
    tmp = []
    for j in range(a):
        tmp.append("*")
    print(''.join(tmp))