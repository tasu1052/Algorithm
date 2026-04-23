import heapq
def solution(operations):
    maxh = []
    minh = []
    visited = [False] * len(operations)
    
    for i in range(len(operations)):
        com, num = operations[i].split()
        num = int(num)
        
        if com == "I":
            heapq.heappush(maxh, (-num, i))
            heapq.heappush(minh, (num, i))
            visited[i] = True
            
        else:
            if num == 1:
                while maxh and not visited[maxh[0][1]]:
                    heapq.heappop(maxh)
                
                if maxh:
                    visited[maxh[0][1]] = False
                    heapq.heappop(maxh)
                    
            else:
                while minh and not visited[minh[0][1]]:
                    heapq.heappop(minh)
                
                if minh:
                    visited[minh[0][1]] = False
                    heapq.heappop(minh)
                

    while maxh and not visited[maxh[0][1]]:
        heapq.heappop(maxh)

    while minh and not visited[minh[0][1]]:
        heapq.heappop(minh)

    if not maxh or not minh:
        return [0, 0]

    return [-maxh[0][0], minh[0][0]]