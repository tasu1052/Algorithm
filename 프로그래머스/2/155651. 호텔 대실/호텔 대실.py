import heapq

def solution(book_time):
    room = []
    
    hq = []
    
    for book in book_time:
        startTime = int(book[0][:2]) * 60 + int(book[0][3:5])
        endTime = int(book[1][:2]) * 60 + int(book[1][3:5])
        
        heapq.heappush(hq, (startTime, endTime))
      
    while hq:
        time = heapq.heappop(hq)
        flag = False
        
        for i in range(len(room)):
            if room[i][-1][1] + 10 <= time[0]:
                print(room[i][-1])
                room[i].append(time)
                flag = True
                break
        if not flag:        
            room.append([time])

    answer = len((room))
    return answer