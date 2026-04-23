from collections import deque
def solution(s):
    st = deque()
    
    for ch in s:
        if ch == "(":
            st.append(ch)
        else:
            if st:
                st.pop()
            else:
                return False
                
    if st:
        return False
    return True