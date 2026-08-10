class Solution {
    public int[] solution(int n) {
        //어떤 방향으로 나아가야 하면 dx, dy 생각하기
        //좌표 갱신 후 어떤 조건 되면 방향 바꾸는 시뮬레이션
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        int[][] arr = new int[n][n];
        int num = 1;
        int dir = 0;
        int x = 0, y = 0;
        for(int i=n; i>=1; i--){
            for(int j=0; j<i; j++){
                arr[x][y] = num++;
                
                x += dx[dir];
                y += dy[dir];
            }
            
            x -= dx[dir];
            y -= dy[dir];
            
            dir = (dir + 1) % 3;
            
            x += dx[dir];
            y += dy[dir];
        }
        
        int[] answer = new int[n * (n+1) / 2];
        int idx = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}