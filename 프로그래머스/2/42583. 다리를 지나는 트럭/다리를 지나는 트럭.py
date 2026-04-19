from collections import deque
def solution(bridge_length, weight, truck_weights):
    bridge = deque([0] * bridge_length)
    cur_weight = 0
    time = 0
    trucks = deque(truck_weights)
    
    while bridge:
        time += 1
        
        cur_weight -= bridge.popleft()
        
        if trucks:
            if cur_weight + trucks[0] <= weight:
                truck = trucks.popleft()
                bridge.append(truck)
                cur_weight += truck
            else:
                bridge.append(0)
                
    return time
            