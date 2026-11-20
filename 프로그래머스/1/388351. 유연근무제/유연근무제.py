def solution(schedules, timelogs, startday):
    answer = 0
    startday -= 1
    
    for i in range(len(timelogs)):
        flag = True
        
        limit = schedules[i] + 10
        if limit % 100 >= 60:
            limit += 40
        for j in range(len(timelogs[0])):
            today = (startday + j) % 7
            if limit < timelogs[i][j]:
                if today != 5 and today != 6:
                    flag = False
                    break
        if flag:
            answer += 1
    return answer