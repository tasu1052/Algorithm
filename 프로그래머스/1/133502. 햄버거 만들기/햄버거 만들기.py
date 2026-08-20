def solution(ingredient):
    answer = 0
    st = []
    
    for i in ingredient:
        st.append(i)
        
        if st[-4:] == [1, 2, 3, 1]:
            answer += 1
            
            del st[-4:]
    return answer