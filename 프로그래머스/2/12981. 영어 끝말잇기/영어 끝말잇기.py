def solution(n, words):
    #앞 단어 끝말잇기 못하거나 말했던 단어 말하면 out 시키고 그사람 턴이랑 위치 반환시키기
    answer = [0, 0]
    s = {words[0]}
    turn = 1
    idx = 1
    prev = words[0]
    
    for word in words[1:]: #단어 순회하면서
        if word[0] == prev[-1]: #앞단어 마지막 말이랑 지금 단어 첫말 같고
            if word in s: #그 단어가 만약 이미 말한거면 현재 번호, 차례 반환
                answer[0] = idx + 1
                answer[1] = turn
                break
            else:
                s.add(word)
                prev = word
                idx = (idx + 1) % n
                if idx == 0:
                    turn += 1
        else:
            answer[0] = idx + 1
            answer[1] = turn
            break
    
    return answer