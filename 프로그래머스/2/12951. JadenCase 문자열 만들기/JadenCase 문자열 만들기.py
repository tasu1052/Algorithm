def solution(s):
    result = []
    new_word = True
    
    for ch in s:
        if ch == ' ':
            result.append(ch)
            new_word = True
        else:
            if new_word:
                result.append(ch.upper())
                new_word = False
            else:
                result.append(ch.lower())
    return ''.join(result)