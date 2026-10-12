from collections import deque
def solution(queue1, queue2):
    answer = 0
    
    oneSum = sum(queue1)
    twoSum = sum(queue2)
    
    if (oneSum + twoSum) % 2 != 0:
        return -1
    
    oneq = deque(queue1)
    twoq = deque(queue2)
    
    n = len(queue1)
    while oneSum != twoSum and answer < 4 * n:
        if oneSum > twoSum:
            target = oneq.popleft()
            oneSum -= target
            twoq.append(target)
            twoSum += target
            
            answer += 1
            
        elif oneSum < twoSum:
            target = twoq.popleft()
            twoSum -= target
            oneq.append(target)
            oneSum += target
            
            answer += 1

    if oneSum == twoSum:
        return answer

    return -1