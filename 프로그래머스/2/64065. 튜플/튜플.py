def solution(s):
    answer = []
    num = set()
    tupleList = []

    tmp = ''
    tmpList = []

    for c in s:
        if c.isdecimal():
            tmp += c

        elif c == ',':
            if tmp:
                tmpList.append(int(tmp))
                tmp = ''

        elif c == '}':
            if tmp:
                tmpList.append(int(tmp))
                tmp = ''

            if tmpList:
                tupleList.append(tmpList)
                tmpList = []

    tupleList.sort(key=len)

    for tup in tupleList:
        for t in tup:
            if t not in num:
                num.add(t)
                answer.append(t)

    return answer