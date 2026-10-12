n = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

# Please write your code here.
A.sort()
B.sort()

flag = True

for i in range(len(A)):
    if A[i] != B[i]:
        flag = False
        break

if flag:
    print("Yes")
else:
    print("No")