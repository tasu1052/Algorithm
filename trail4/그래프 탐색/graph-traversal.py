def dfs(n):
    visited[n] = True

    for next in graph[n]:
        if not visited[next]:
            dfs(next)
n, m = map(int, input().split())
edges = [tuple(map(int, input().split())) for _ in range(m)]

graph = [[] for _ in range(n+1)]
visited = [False] * (n + 1)

for e in edges:
    graph[e[0]].append(e[1])
    graph[e[1]].append(e[0])


dfs(1)

print(sum(visited) - 1)
# Please write your code here.
