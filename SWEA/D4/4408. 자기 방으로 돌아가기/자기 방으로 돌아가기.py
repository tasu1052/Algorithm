T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    corridor = [0] * 201

    for _ in range(N):
        a, b = map(int, input().split())

        if a > b:
            a, b = b, a

        start = (a + 1) // 2
        end = (b + 1) // 2

        for i in range(start, end + 1):
            corridor[i] += 1

    answer = max(corridor)
    print(f"#{tc} {answer}")