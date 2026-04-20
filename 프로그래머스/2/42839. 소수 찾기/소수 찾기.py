import math
made = set()
visited = []
def solution(numbers):
    global made, visited
    visited = [False] * len(numbers)
    made = set()
    
    numList = list(numbers)
    
    dfs(numList, "")
    
    answer = 0
    for num in made:
        if isPrime(num):
            answer += 1
    return answer

def dfs(numl, total):
    global made, visited
    
    if total != "":
        made.add(int(total))
    
    for i in range(len(numl)):
        if not visited[i]:
            visited[i] = True
            dfs(numl, total + numl[i])
            visited[i] = False
            
def isPrime(n):
    if n < 2:
        return False
    for i in range(2, int(math.sqrt(n))+1):
        if n % i == 0:
            return False
    return True
        