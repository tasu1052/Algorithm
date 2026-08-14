def solution(a, b):
    day = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    
    sum = 0
    for i in range(a-1):
        sum += month[i]
    sum += b
    
    answer = day[sum % 7 - 1]
    return answer