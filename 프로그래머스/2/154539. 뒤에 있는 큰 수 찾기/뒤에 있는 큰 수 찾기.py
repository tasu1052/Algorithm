def solution(numbers):
    #스택에다가 for문 한번 돌면서 스택 넣고
    #다음꺼랑 비교해서 전부 빼고 하면 되지 않나
    answer = [-1] * len(numbers)
    st = []
    
    for idx, num in enumerate(numbers):
        while st and st[-1][1] < num:
            prev_idx, prev_num = st.pop()
            answer[prev_idx] = num
            
        st.append((idx, num))
        
    return answer