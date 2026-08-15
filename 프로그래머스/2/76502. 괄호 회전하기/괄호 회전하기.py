from collections import deque
def solution(s):
    #큐 하나 선언해서 문자열 전부 넣어놓고
    #큐 순회하면서 스택에 넣으면서
    #스택에 아무것도 없으면 ans++하면 되지 않을까?
    ans = 0
    q = deque(s)
    
    for _ in range(len(s)):
        stack = []
        flag = True
        
        for ch in q:
            if ch == '[' or ch == '{' or ch == '(':
                stack.append(ch)
                
            else:
                if not stack:
                    flag = False
                    break
                
                if ch == ']':
                    if stack[-1] == '[':
                        stack.pop()
                    else:
                        flag = False
                        break
                elif ch == '}':
                    if stack[-1] == '{':
                        stack.pop()
                    else:
                        flag = False
                        break

                elif ch == ')':
                    if stack[-1] == '(':
                        stack.pop()
                    else:
                        flag = False
                        break
                        
        if flag and not stack:
            ans += 1
        
        q.append(q.popleft())
                
                        
    return ans