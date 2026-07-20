import java.util.*;

class Solution {
    static ArrayList<Integer>[] list;
    static int ans;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        list = new ArrayList[n];
        visited = new boolean[n];
        ans = 0;
        for(int i=0; i<n; i++) list[i] = new ArrayList<>();
        
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[0].length; j++){
                if(i == j) continue;
                
                if(computers[i][j] == 1){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                ans++;
            }
        }
        
        return ans;
    }
    static void dfs(int now){
        visited[now] = true;
        
        for(int next : list[now]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}