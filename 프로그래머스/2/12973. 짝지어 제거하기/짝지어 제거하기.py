from collections import deque
def solution(s):
    st = deque()
    
    arr = list(s)
    
    for i in range(len(arr)):
        if st and st[-1] == arr[i]:
            st.pop()
        else:
            st.append(arr[i])
            
    if not st:
        return 1
    else:
        return 0