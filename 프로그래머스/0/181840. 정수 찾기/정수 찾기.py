def solution(num_list, n):
    flag = False
    for i in num_list:
        if i == n:
            flag = True
            break
    if flag:
        return 1
    else:
        return 0