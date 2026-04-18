from collections import deque
import math
def solution(progresses, speeds):
    #큐에 작업들 전부 넣어놓고
    #큐 한 바퀴 돌기
    #100에서 각 작업들 시간 뺀 날짜를 시간으로 나눈거를 반올림한게 소요 날짜
    #앞 작업이 소요된 날짜보다 뒤에 날짜가 작으면 뒤꺼도 같이 빼기
    #뺀 만큼 배포한 기능 수 카운트 증가
    #이거를 저장하는 ans 배열에 값 추가
    ans = []
    dayq = deque()
    
    for i in range(len(progresses)):
        day = math.ceil((100 - progresses[i]) / speeds[i])
        dayq.append(day)
        
    while dayq:
        completedDay = dayq.popleft()
        functions = 1;
        
        while dayq and dayq[0] <= completedDay:
            dayq.popleft()
            functions += 1
        
        ans.append(functions)
    
    return ans