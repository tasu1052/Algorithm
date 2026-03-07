class Solution {
    static int ans;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        ans = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j] == 1 && !visited[j]){
                    visited[j] = true;
                    dfs(j, n, computers);
                    ans++;
                }
            }
        }
        return ans;
    }
    static void dfs(int idx, int n, int[][] computers){
        for(int j=0; j<n; j++){
            if(computers[idx][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(j, n, computers);
            }
        }
    }
}