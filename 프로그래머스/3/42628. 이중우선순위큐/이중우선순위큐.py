import heapq
def solution(operations):
    maxh = []
    minh = []
    for i in range(len(operations)):
        com, num = operations[i].split()
        num = int(num)
        
        if com == "I":
            heapq.heappush(maxh, -num)
            heapq.heappush(minh, num)
        elif maxh and com == "D":
            if num == 1:
                remove_value = -heapq.heappop(maxh)
                minh.remove(remove_value)
                heapq.heapify(minh)
            else: #최소값 삭제
                remove_value = -heapq.heappop(minh)
                maxh.remove(remove_value)
                heapq.heapify(maxh)
             
    if not maxh:
        return [0, 0]
    else:
        return [-heapq.heappop(maxh), heapq.heappop(minh)]
                