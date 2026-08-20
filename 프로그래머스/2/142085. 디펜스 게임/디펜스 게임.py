import heapq
def solution(n, k, enemy):
    #enemy 가장 클 때 무적권 쓰는게 맞음
    #병사로 일단 처리하고 병사 수가 음수되면
    #우선순위 큐에서 가장 enemy 컸던 라운드 수복시키고 무적권 하나 사용
    answer = 0
    pq = []
    for idx, e in enumerate(enemy):
        n -= e
        heapq.heappush(pq, -e)
        if n < 0:
            if k > 0:
                n += -heapq.heappop(pq)
                k -= 1
            else:
                return idx
    if n >= 0:
        answer = len(enemy)
    return answer