def solution(genres, plays):
    #속한 노래 많이 재생 장르 먼저
    #장르 내에서 많이 재생된 노래 먼저
    #장르 내 재생횟수 같은 노래 중 고유 번호 낮은 순
    
    #딕셔너리 하나 해서 전체 장르 별 재생횟수 내림차순 정렬
    #genres 리스트 순회하면서 정렬된 장르마다 리스트 만들고 재생횟수 번호 별 리스트 만들고 정렬
    #그리고 상위 두개 뽑기
    
    playGenreDict = {} #장르 별 재생횟수 저장 딕셔너리
    for i in range(len(genres)): #장르 별 재생횟수 저장하기
        playGenreDict[genres[i]] = playGenreDict.get(genres[i], 0) + plays[i]
    
    genreList = sorted(playGenreDict.items(), key = lambda x : x[1], reverse = True)
    
    answer = []
    
    genreIdx = 0
    while genreIdx < len(genreList):
        tmp = []
        for i in range(len(genres)):
            if genres[i] == genreList[genreIdx][0]:
                tmp.append((plays[i], i))
        tmp.sort(key = lambda x : (-x[0], x[1]))
        
        answer.append(tmp[0][1])
        if(len(tmp) >= 2):
            answer.append(tmp[1][1])
        
        genreIdx += 1
    return answer