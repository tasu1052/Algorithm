n = int(input())
nums = list(map(int, input().split()))

# Please write your code here.
origin = sorted(nums)[0:n]
reverse = sorted(nums, reverse = True)[0:n]

total = []
for i in range(len(origin)):
    total.append(origin[i] + reverse[i])

print(max(total))