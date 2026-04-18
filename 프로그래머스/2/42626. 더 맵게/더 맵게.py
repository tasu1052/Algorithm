import heapq
def solution(scoville, K):
    #우선순위 큐를 스코빌기준 오름차순 정렬
    #while 사용해서 무한반복
    #처음 뽑은 음식의 스코빌 지수가 K이상이면 while 종료
    #음식 섞을 때마다 섞은 횟수 증가
    pq = []
    cnt = 0
    
    for i in range(len(scoville)):
        heapq.heappush(pq, scoville[i])
        
    while True:
        first = heapq.heappop(pq)
        
        if first >= K:
            break;
        
        if pq:
            second = heapq.heappop(pq)
        else:
            return -1
        
        if first == 0 and second == 0:
            return -1
        
        newFood = first + (second * 2)
        heapq.heappush(pq, newFood)
        cnt += 1
        
    return cnt
        
    
    