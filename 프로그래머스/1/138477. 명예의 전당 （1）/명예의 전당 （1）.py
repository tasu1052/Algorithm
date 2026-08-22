import heapq
def solution(k, score):
    #우선순위 큐에 점수 넣어놓고
    #맨 위꺼보다 점수 크면 큐에 넣고 맨위에꺼 빼기
    answer = []
    pq = []
    
    for idx, s in enumerate(score):
        if idx < k: #날짜가 k보다 적으면 그냥 넣기
            heapq.heappush(pq, s)
            answer.append(pq[0])
            continue
            
        if s > pq[0]: #현재 명예의 전당 최소 점수보다 점수가 높으면 큐에 넣기
            heapq.heappop(pq)
            heapq.heappush(pq, s)
            
        answer.append(pq[0])
            
        
    return answer