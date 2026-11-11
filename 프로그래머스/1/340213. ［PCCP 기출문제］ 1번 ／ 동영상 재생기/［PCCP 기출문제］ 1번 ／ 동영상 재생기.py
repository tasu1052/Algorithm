def solution(video_len, pos, op_start, op_end, commands):
    #모든 길이 전부 초로 변환 후
    #commands 순회하면서 10초 전후 조건 처리
    #오프닝 건너뛰기 처리
    #전부 하고 난 후 분초로 변환하고 0붙이기
    answer = ''
    video = int(video_len.split(":")[0]) * 60 + int(video_len.split(":")[1])
    cur = int(pos.split(":")[0]) * 60 + int(pos.split(":")[1])
    opStart = int(op_start.split(":")[0]) * 60 + int(op_start.split(":")[1])
    opEnd = int(op_end.split(":")[0]) * 60 + int(op_end.split(":")[1])
    
    for com in commands:
        if opStart <= cur <= opEnd:
            cur = opEnd
            
        if com == 'prev':
            cur -= 10
            if cur < 0:
                cur = 0
        else:
            cur += 10
            if cur > video:
                cur = video
                
    if opStart <= cur <= opEnd:
            cur = opEnd
                
    minute = str(cur // 60)
    second = str(cur % 60)
    
    if len(minute) == 1:
        minute = '0' + minute
    if len(second) == 1:
        second = '0' + second
        
    answer = minute + ':' + second
        
    return answer

'''
10초전후 이동 끝값은 00혹은 마지막위치로
오프닝 구간은 건너뛰기
분초가 한자리일 경우 0을 붙여 두자리로
'''