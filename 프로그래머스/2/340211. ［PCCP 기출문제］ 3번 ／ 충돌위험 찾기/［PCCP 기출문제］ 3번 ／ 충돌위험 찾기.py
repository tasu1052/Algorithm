def solution(points, routes):
    paths = []

    # 1. 각 로봇의 전체 이동 경로 구하기
    for route in routes:
        x, y = points[route[0] - 1]
        path = [(x, y)]

        for i in range(1, len(route)):
            tx, ty = points[route[i] - 1]

            # r 좌표 먼저 이동
            while x != tx:
                if x < tx:
                    x += 1
                else:
                    x -= 1

                path.append((x, y))

            # c 좌표 이동
            while y != ty:
                if y < ty:
                    y += 1
                else:
                    y -= 1

                path.append((x, y))

        paths.append(path)

    # 2. 가장 긴 이동 경로의 길이 구하기
    max_time = 0

    for path in paths:
        if len(path) > max_time:
            max_time = len(path)

    # 3. 매초 충돌 위험 계산
    answer = 0

    for t in range(max_time):
        visited = {}

        for path in paths:
            if t < len(path):
                pos = path[t]
                visited[pos] = visited.get(pos, 0) + 1

        for pos in visited:
            if visited[pos] >= 2:
                answer += 1

    return answer