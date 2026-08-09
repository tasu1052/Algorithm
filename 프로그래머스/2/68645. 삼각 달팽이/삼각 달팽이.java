class Solution {
    public int[] solution(int n) {
        //1 = 1, 2 = 3, 3 = 6, 4 = 10, 5 = 15, 6 = 21
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        int[][] arr = new int[n][n];
        int dir = 0;
        int num = 1;
        int x = 0, y = 0;
        for(int i=n; i>=1; i--){
            for(int j=0; j<i; j++){
                arr[x][y] = num;
                
                x += dx[dir];
                y += dy[dir];
                
                num++;
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
            for(int j=0; j<n; j++){
                if(arr[i][j] != 0){
                    answer[idx++] = arr[i][j];
                }
            }
        }
        return answer;
    }
}