import math
def solution(weights):
    #딕셔너리에 weights 순회하면서
    #2, 3, 4에 해당하는 거리에 대해 수 저장하고
    #수들마다 조합돌린거 더하면 되지 않을까?
    #이때 무게 같은 경우 먼저 계산 후 set으로 중복 없애고
    #다른 무게 계산해봤는데 set으로 중복없애지면서 쌍들 계산 안되는 경우 발생해서 안됨
    
    #비율을 1:1, 1:2, 2:3, 3:4로 놓고 
    answer = 0
    dic = {}
    
    weights.sort()

    for w in weights:
        answer += dic.get(w, 0)
        answer += dic.get(w * 2 / 3, 0)
        answer += dic.get(w * 1 / 2, 0)
        answer += dic.get(w * 3 / 4, 0)

        dic[w] = dic.get(w, 0) + 1
    
    return answer