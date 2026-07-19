import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] list;
        list = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++){
            int s = edge[i][0];
            int e = edge[i][1];
            
            list[s].add(e);
            list[e].add(s);
        }
        
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : list[now]){
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            max = Math.max(max, dist[i]);
        }
        
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == max) answer++;
        }
        return answer;
    }
}