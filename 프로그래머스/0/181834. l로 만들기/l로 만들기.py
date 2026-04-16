def solution(myString):
    S = ""
    for i in myString:
        if i < "l":
            S += "l"
        else:
            S += i
    answer = S
    return answer