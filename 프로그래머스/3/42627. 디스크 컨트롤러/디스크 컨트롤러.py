import heapq
def solution(jobs):
    jobs.sort() #요청시간, 소요시간 기준으로 정렬
    
    n = len(jobs) #작업 개수
    total = 0 #전체 반환시간
    done = 0 #완료한 작업 수
    idx = 0 #아직 도착안한 다음 작업
    time = 0 #현재 시각
    heap = [] #소요시간, 요청시간 기준 정렬하는 우선순위 큐
    
    while done < n:
        while idx < n and jobs[idx][0] <= time: #현재 시간보다 더 빨리 요청된 작업 전부 힙에 넣음
            request, duration = jobs[idx]
            heapq.heappush(heap, (duration, request))
            idx += 1
            
        if heap:
            duration, request = heapq.heappop(heap)
            time += duration
            total += time - request
            done += 1
        else:
            time = jobs[idx][0]
    return total // n
    