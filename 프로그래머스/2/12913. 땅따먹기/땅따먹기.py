def solution(land):
    n = len(land)

    dp = [[0] * 4 for _ in range(n)]

    # 첫 번째 행은 그대로
    for j in range(4):
        dp[0][j] = land[0][j]

    # 두 번째 행부터
    for i in range(1, n):
        for j in range(4):

            max_value = 0

            # 이전 행의 4칸 확인
            for k in range(4):

                # 같은 열은 선택 불가능
                if j == k:
                    continue

                # 가장 큰 값 저장
                if dp[i - 1][k] > max_value:
                    max_value = dp[i - 1][k]

            # 현재 칸까지 왔을 때 최대 점수
            dp[i][j] = land[i][j] + max_value

    return max(dp[n - 1])