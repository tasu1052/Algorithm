from collections import deque
def solution(arr):
    st = deque()
    
    for i in range(len(arr)):
        if not st or st[-1] != arr[i]:
            st.append(arr[i])
            
    return list(st)