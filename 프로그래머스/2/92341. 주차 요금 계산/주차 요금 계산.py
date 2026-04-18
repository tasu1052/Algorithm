import heapq
import math
def solution(fees, records):
    #입차 후 출차 없으면 23:59 출차
    #누적 주차 시간이 기본시간 이하면 기본 요금
    #기본 시간 초과시 기본 요금 + 초과시간만큼 단위시간*단위요금
    #이때 초과시간이 단위시간으로 나누어떨어지지않으면 올림
    #차량번호 작은 자동차부터 주차요금 return
    
    #fee[0]=기본시간, [1]=기본요금, [2]=단위시간, [3]=단위요금
    #records[0]=시각, [1]=차량번호, [2]=내역
    
    result = []
    parking = {}
    total = {}
    
    for record in records:
        time, num, state = record.split()
        h, m = map(int, time.split(":"))
        minutes = h * 60 + m
        
        if state == "IN":
            parking[num] = minutes
        else: #OUT
            total[num] = total.get(num, 0) + (minutes - parking[num])
            del parking[num]
        end_time = 23 * 60 + 59
        
    for num in parking:
        total[num] = total.get(num, 0) + (end_time - parking[num])
            
    for num in sorted(total):
        pretime = total[num]
        if pretime <= fees[0]:
            result.append(fees[1])
        else:
            result.append(fees[1] + math.ceil((pretime - fees[0]) / fees[2]) * fees[3])
    return result
                