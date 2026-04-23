import heapq
def solution(jobs):
    jobs.sort()
    
    n = len(jobs)
    waitq = []
    time = 0
    idx = 0
    done = 0
    total = 0
    totalResponseTime = []
    
    while done < n:
        while idx < n and jobs[idx][0] <= time:
            heapq.heappush(waitq, (jobs[idx][1], jobs[idx][0]))
            idx += 1
            
        if waitq:
            duration, request = heapq.heappop(waitq)
            time += duration
            total = time - request
            totalResponseTime.append(total)
            done += 1
        else:
            time = jobs[idx][0]
        
    return sum(totalResponseTime) // len(totalResponseTime)