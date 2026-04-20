words = []
def solution(word):
    global words
    alpha = ['A', 'E', 'I', 'O', 'U']
    words = []
    
    dfs(0, alpha, "")
    answer = words.index(word)
    return answer

def dfs(cnt, alpha, total):
    if cnt >= 6:
        return
    
    global words
    if cnt <= 5:
        words.append(total)
    
    for i in range(len(alpha)):
        dfs(cnt+1, alpha, total+alpha[i])
    
        
        