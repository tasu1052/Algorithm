class Solution {
    static int ans;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        //k = 현재 피로도
        //dungenons -> 최소 필요 피로도, 소모 피로도
        ans = Integer.MIN_VALUE;
        visited = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        return ans;
    }
    static void dfs(int cnt, int k, int[][] dungeons){
        ans = Math.max(ans, cnt);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i]){
                if(k >= dungeons[i][0]){
                    visited[i] = true;
                    dfs(cnt + 1, k - dungeons[i][1], dungeons);
                    visited[i] = false;
                }
            }
        }
    }
}