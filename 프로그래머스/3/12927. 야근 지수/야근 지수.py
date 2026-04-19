import heapq
def solution(n, works):
    maxh = [-x for x in works]
    heapq.heapify(maxh)
    
    for i in range(n):
        num = -heapq.heappop(maxh) #음수 뽑아서 양수로 바꾸고
        if num == 0:
            break
        num -= 1 #최대인 값 뽑아서 -1
        heapq.heappush(maxh, -num) #다시 음수로 바꿔서 넣기
    
    answer = 0
    
    while maxh:
        answer += (-heapq.heappop(maxh)) ** 2
        
    return answer