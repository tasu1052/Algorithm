from collections import deque
def solution(begin, target, words):
    
    answer = bfs(begin, target, words)
    return answer

def bfs(begin, target, words):
    s = set()
    q = deque()
    q.append((begin, 0))
    
    cnt = 0
    while q:
        nowWord, nowCnt = q.popleft()
        
        if nowWord == target:
            return nowCnt
        
        for word in words:
            changeCnt = 0
            
            for i in range(len(word)):
                if word[i:i+1] != nowWord[i:i+1]:
                    changeCnt += 1
            
            if changeCnt == 1 and word not in s:
                s.add(word)
                q.append((word, nowCnt + 1))
    return 0        
            