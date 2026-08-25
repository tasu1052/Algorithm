def solution(order):
    #스택 사용해서 보조 컨베 구현
    #order와 보조 둘 다 확인 후 못 싣기 전까지 answer++ 안되면 return
    answer = 0
    num = 1 #현재 컨베 물건 번호
    st = []
    
    for o in order:
        if o == num:
            num += 1
            answer += 1
            continue
        else:
            while num <= o:
                st.append(num)
                num += 1
            if o == st[-1]:
                st.pop()
                answer += 1
                continue
        return answer
    return answer