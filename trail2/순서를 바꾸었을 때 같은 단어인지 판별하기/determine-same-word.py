word1 = input()
word2 = input()

# Please write your code here.
word1 = sorted(word1)
word2 = sorted(word2)

if len(word1) != len(word2):
    print("No")
else:
    flag = True
    for i in range(len(word1)):
        if word1[i] != word2[i]:
            flag = False
            print("No")
            break
    if flag:
        print("Yes")