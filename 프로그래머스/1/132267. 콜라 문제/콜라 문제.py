def solution(a, b, n):
    #dfs 돌면서 b로 나눠서 몫, 나머지 더해서 다음 단계로 가져가고 받는 콜라는 전역으로
    ans = 0
    while n >= a:
        newCola = 0
        newCola += (n // a) * b
        ans += newCola
        newCola += n % a
        n = newCola
    return ans