import heapq
def solution(bandage, health, attacks):
    time = 0
    curHealth = health
    
    pq = []
    for attack in attacks: #우선순위큐에 attack 전부 넣고
        heapq.heappush(pq, attack)
    '''
    curAttack으로 공격시간이랑 bandage 시전시간 비교해서
    공격시간 - 현재시간이 bandage보다 작거나 같으면 중간에 공격당한것
    더 크면 bandage성공한것 bandage로 그거 나눠서 몇번 성공했는지랑 남은 시간 각각
    체력 추가해주면 될듯?
    '''
    while pq:
        attackTime, damage = heapq.heappop(pq)
        
        calTime = attackTime - time - 1
        if calTime < bandage[0]:
            curHealth += calTime * bandage[1]
            
            if curHealth > health:
                curHealth = health
        else:
            success = calTime // bandage[0]
            
            curHealth += calTime * bandage[1]
            curHealth += success * bandage[2]
            
            if curHealth > health:
                curHealth = health
                
        curHealth -= damage
        if curHealth <= 0:
            return -1
        
        time = attackTime
        
        
    
    return curHealth


'''
t초 동안 1초마다 x 체력 회복
t초 연속 붕대 감으면 y체력 추가
체력 상한선 존재
체력 0되면 죽음
'''